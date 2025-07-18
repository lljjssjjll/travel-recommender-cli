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
val googleGenAiVersion = "1.8.0"
val openAiVersion = "0.18.2"

dependencies {
    testImplementation(kotlin("test"))

    implementation("com.google.code.gson:gson:${gsonVersion}")
    implementation("com.google.genai:google-genai:${googleGenAiVersion}")
    implementation("com.theokanning.openai-gpt3-java:service:${openAiVersion}")
}

tasks.test {
    useJUnitPlatform()
}
