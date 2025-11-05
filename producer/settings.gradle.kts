pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
  }
}

plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

val repo = rootDir.parentFile.resolve("repo")

dependencyResolutionManagement {
  repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
  repositories {
    maven(url = repo)
    mavenCentral()
  }
}

rootProject.name = "producer"

include("producer")
