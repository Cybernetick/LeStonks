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
                api(project(":data"))
                implementation(libs.kotlininject.runtime)
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

ksp {
    arg("me.tatarka.inject.dumpGraph", "true")
    arg("me.tatarka.inject.generateCompanionExtensions", "true")
}

addKspDependencyForAllTargets(libs.kotlininject.compiler)