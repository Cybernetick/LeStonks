import personal.vankhulup.buildconvention.addKspDependencyForAllTargets

plugins {
    id("com.android.library")
    id("personal.vankhulup.plugin.multiplatform")
    alias(libs.plugins.ksp)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":api"))
                implementation(project(":db-sqldelight"))
            }
        }

    }
}

android {
    namespace = "personal.vankhulup.lestonks"
    compileSdk = 33
    defaultConfig {
        minSdk = 28
    }
}

addKspDependencyForAllTargets(libs.kotlininject.compiler)