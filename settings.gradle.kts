pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LeStonks"
includeBuild("sharedBuildLogic")
include(":androidApp")
include(":shared")
include(":api")
include(":models")
include(":db-sqldelight")
include(":data")
