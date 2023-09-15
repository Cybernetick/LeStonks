package personal.vankhulup.buildconvention

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class AndroidFeatureConventionPlugin : Plugin<Project> {

  override fun apply(target: Project) {
    with(target) {
      with (pluginManager) {
        apply("com.android.library")
        apply("org.jetbrains.kotlin.android")
      }

      configureAndroid()
      configureKotlin()
      extensions.configure<LibraryExtension> {
        configureAndroidCompose(this)
      }

      dependencies{
        add("implementation", project(":shared"))
        add("api", platform(libs.findLibrary("compose-bom").get()))
        add("api", libs.findLibrary("compose-material3").get())
        add("api", libs.findLibrary("compose-ui-tooling-preview").get())
        add("api", libs.findLibrary("compose-material-icons").get())
        add("debugApi", libs.findLibrary("compose-ui-tooling").get())

        add("implementation", libs.findLibrary("androidx-viewmodel").get())
        add("implementation", libs.findLibrary("kotlin-coroutines-android").get())

        add("implementation", libs.findLibrary("kotlininject-runtime").get())
      }
    }
  }
}