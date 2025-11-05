plugins {
  alias(libs.plugins.kotlin.jvm)
  id("maven-publish")
  id("java-test-fixtures")
}

group = "producer"
version = "1.0"

val repo = rootDir.parentFile.resolve("repo")

publishing {
  publications {
    create<MavenPublication>("maven") {
      from(components["java"])
    }
  }
  repositories {
    maven {
      name = "local"
      url = uri(repo)
    }
  }
}

dependencies {
  testFixturesImplementation(testFixtures("consumer:b:1.0"))

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
