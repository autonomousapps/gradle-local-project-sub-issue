pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
  }
}

plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
  id("com.gradle.develocity") version "4.2.2"
}

develocity {
  buildScan {
    publishing.onlyIf { true }

    termsOfUseUrl.set("https://gradle.com/help/legal-terms-of-use")
    termsOfUseAgree.set("yes")
  }
}

val repo = rootDir.parentFile.resolve("repo")

dependencyResolutionManagement {
  repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
  repositories {
    maven(url = repo)
    mavenCentral()
  }
}

rootProject.name = "consumer"

include("a", "b")
