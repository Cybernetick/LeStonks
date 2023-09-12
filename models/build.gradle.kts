import personal.vankhulup.buildconvention.configureAndroid

plugins {
//    kotlin("multiplatform") version "1.9.0"
    id("com.android.library")
    id("personal.vankhulup.plugin.multiplatform")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {

//    targetHierarchy.default()
//    androidTarget()
//
//    listOf(
//        iosX64(),
//        iosArm64(),
//        iosSimulatorArm64()
//    ).forEach {
//        it.binaries.framework {
//            baseName = "models"
//        }
//    }
    sourceSets {
        val commonMain by getting
    }
}
android {
    namespace = "personal.vankhulup.models"
}

configureAndroid()

//android {
//    namespace = "personal.vankhulup.api"
//    compileSdk = 33
//    defaultConfig {
//        minSdk = 28
//    }
//}