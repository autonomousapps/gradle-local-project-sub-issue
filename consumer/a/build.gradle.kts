plugins {
  alias(libs.plugins.kotlin.jvm)
  id("java-test-fixtures")
}

//group = "consumer"
//version = "1.0"

configurations.configureEach {
  resolutionStrategy {
//    preferProjectModules() // doesn't work
    dependencySubstitution {
      // works, but doesn't repro the issue
//      substitute(variant(module("consumer:b:1.0")) {
//        capabilities {
//          requireCapability("consumer:b-test-fixtures")
//        }
//      }).using(project(":b"))

      // works, but doesn't repro the issue
      substitute(variant(module("consumer:b:1.0")) {
        capabilities {
          requireCapability("consumer:b-test-fixtures")
        }
      }).using(variant(project(":b")) {
        capabilities {
          requireCapability("consumer:b-test-fixtures")
        }
      })
    }
  }
}

dependencies {
  testImplementation(testFixtures(libs.producer))

  testImplementation(libs.junit.jupiter)
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

tasks.test {
  useJUnitPlatform()
}
