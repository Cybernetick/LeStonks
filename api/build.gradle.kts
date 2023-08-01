plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.8.21"
    alias(libs.plugins.buildConfig)
}

buildConfig {
    packageName("personal.vankhulup.api")

    buildConfigField("String", "POLYGON_API_KEY", "\"BA1ZdnNY69dU2uDckXd2cli5Ri9n47NH\"")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "api"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.auth)
                implementation(libs.ktor.contentnegotiation)
                implementation(libs.ktor.kotlinxserialization)
                implementation(libs.kotlin.coroutines.core)
            }
        }

        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.client.okhttp)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "personal.vankhulup.api"
    compileSdk = 33
    defaultConfig {
        minSdk = 28
    }
}