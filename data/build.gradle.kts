import personal.vankhulup.buildconvention.configureAndroid

plugins {
    id("com.android.library")
    id("personal.vankhulup.plugin.multiplatform")
    alias(libs.plugins.ksp)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":api"))
                api(project(":db-sqldelight"))
                implementation(libs.kotlininject.runtime)
            }
        }
    }
}

configureAndroid()

android {
    namespace = "personal.vankhulup.data"
}