plugins {
    kotlin("jvm") version "2.0.21"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

group = "com.lljjssjjll"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val gsonVersion = "2.13.1"

dependencies {
    testImplementation(kotlin("test"))

    implementation("com.google.code.gson:gson:${gsonVersion}")
}

tasks.test {
    useJUnitPlatform()
}
