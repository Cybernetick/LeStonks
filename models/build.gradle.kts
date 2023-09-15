import personal.vankhulup.buildconvention.configureAndroid

plugins {
    id("com.android.library")
    id("personal.vankhulup.plugin.multiplatform")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {

    sourceSets {
        val commonMain by getting
    }
}
android {
    namespace = "personal.vankhulup.models"
}

configureAndroid()