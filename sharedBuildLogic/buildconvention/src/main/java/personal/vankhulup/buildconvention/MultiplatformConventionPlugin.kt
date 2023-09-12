package personal.vankhulup.buildconvention

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

@OptIn(ExperimentalKotlinGradlePluginApi::class)
class MultiplatformConventionPlugin: Plugin<Project> {

  override fun apply(target: Project) {
    with(target) {
      pluginManager.apply("org.jetbrains.kotlin.multiplatform")

      extensions.configure<KotlinMultiplatformExtension>{
        targetHierarchy.default()

        if (pluginManager.hasPlugin("com.android.library")) {
          androidTarget()
        }

        listOf(
          iosX64(),
          iosArm64(),
          iosSimulatorArm64(),
        ).forEach { target ->
          target.binaries.framework {
            baseName = path.substring(1).replace(':', '-')
          }
        }

        configureKotlin()
      }
    }
  }
}