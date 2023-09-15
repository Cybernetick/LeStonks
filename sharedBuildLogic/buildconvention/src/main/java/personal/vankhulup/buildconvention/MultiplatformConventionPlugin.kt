package personal.vankhulup.buildconvention

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

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

        targets.withType<KotlinNativeTarget>().configureEach {
          binaries.all {
            // Add linker flag for SQLite. See:
            // https://github.com/touchlab/SQLiter/issues/77
            linkerOpts("-lsqlite3")
          }
        }

        configureKotlin()
      }
    }
  }
}