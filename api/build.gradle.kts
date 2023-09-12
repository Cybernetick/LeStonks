import personal.vankhulup.buildconvention.configureAndroid

plugins {
    id("com.android.library")
    id("personal.vankhulup.plugin.multiplatform")
    kotlin("plugin.serialization") version "1.9.0"
    alias(libs.plugins.buildConfig)
    alias(libs.plugins.ksp)
}

buildConfig {
    packageName("personal.vankhulup.api")

    buildConfigField("String", "POLYGON_API_KEY", "\"BA1ZdnNY69dU2uDckXd2cli5Ri9n47NH\"")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.ktor.client.core)
                implementation(libs.ktor.client.auth)
                implementation(libs.ktor.contentnegotiation)
                implementation(libs.ktor.kotlinxserialization)
                implementation(libs.kotlin.coroutines.core)
                implementation(libs.kotlininject.runtime)
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
    }
}
configureAndroid()

android {
    namespace = "personal.vankhulup.api"
}