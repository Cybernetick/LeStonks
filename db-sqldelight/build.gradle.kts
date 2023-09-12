import personal.vankhulup.buildconvention.addKspDependencyForAllTargets
import personal.vankhulup.buildconvention.configureAndroid

plugins {
    id("com.android.library")
    id("personal.vankhulup.plugin.multiplatform")
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.ksp)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":models"))
                implementation(libs.sqldelight.coroutines)
                implementation(libs.sqldelight.primitive)
                implementation(libs.kotlininject.runtime)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.sqldelight.android)
            }
        }

        val iosMain by getting {
            dependencies {
                implementation(libs.sqldelight.native)
            }
        }
    }
}

sqldelight {
    databases {
        create("LeStonksDb") {
            packageName.set("personal.vankhulup.dbsqldelight")
        }
    }
}

android {
    namespace = "personal.vankhulup.dbsqldelight"
}

configureAndroid()