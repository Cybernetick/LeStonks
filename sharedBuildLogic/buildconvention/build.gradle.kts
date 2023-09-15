@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  `kotlin-dsl`
}

dependencies {
  compileOnly(libs.android.gradlePlugin)
  compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
  plugins {
    register("multiplatformConvention") {
      id = "personal.vankhulup.plugin.multiplatform"
      implementationClass = "personal.vankhulup.buildconvention.MultiplatformConventionPlugin"
    }

    register("androidLibraryConvention") {
      id = "personal.vankhulup.plugin.androidFeature"
      implementationClass = "personal.vankhulup.buildconvention.AndroidFeatureConventionPlugin"
    }
  }
}