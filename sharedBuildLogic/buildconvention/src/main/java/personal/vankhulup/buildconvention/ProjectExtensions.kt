package personal.vankhulup.buildconvention

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.configurationcache.extensions.capitalized
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType

fun Project.configureKotlin() {
  extensions.configure<JavaPluginExtension> {
    toolchain {
      languageVersion.set(JavaLanguageVersion.of(11))
    }
  }
}

fun Project.configureAndroid() {
  extensions.configure<BaseExtension> {
    compileSdkVersion(Versions.compileSdk)

    defaultConfig {
      minSdk = Versions.minSdk
      targetSdk = Versions.targetSdk
    }

    // Can remove this once https://issuetracker.google.com/issues/260059413 is fixed.
    // See https://kotlinlang.org/docs/gradle-configure-project.html#gradle-java-toolchains-support
    compileOptions {
      sourceCompatibility = JavaVersion.VERSION_11
      targetCompatibility = JavaVersion.VERSION_11

      // https://developer.android.com/studio/write/java8-support
      isCoreLibraryDesugaringEnabled = true
    }
  }

  dependencies {

  }
}

fun Project.addKspDependencyForAllTargets(dependencyNotation: Any) = addKspDependencyForAllTargets("", dependencyNotation)

private fun Project.addKspDependencyForAllTargets(
  configurationNameSuffix: String,
  dependencyNotation: Any,
) {
  val kmpExtension = extensions.getByType<KotlinMultiplatformExtension>()
  dependencies {
    kmpExtension.targets
      .asSequence()
      .filter { target ->
        // Don't add KSP for common target, only final platforms
        target.platformType != KotlinPlatformType.common
      }
      .forEach { target ->
        add(
          "ksp${target.targetName.capitalized()}$configurationNameSuffix",
          dependencyNotation,
        )
      }
  }
}