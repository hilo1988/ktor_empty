@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    application
    kotlin("jvm") version libs.versions.kotlin
    id("org.jetbrains.kotlin.plugin.serialization") version libs.versions.kotlin
}

group = "com.hiloislay.lifelogger"
version = "0.0.1"
application {
    mainClass.set("lifelogger.hiloislay.com.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.bundles.ktor.server)
    implementation(libs.logback.classic)
    implementation(libs.firebase.admin) {
        exclude("com.google.guava", "guava")
    }
    implementation(libs.google.guava)
    implementation(libs.bundles.exposed.impl)

    implementation(libs.bundles.koin.impl)

    implementation(libs.mysql.connector)

    implementation(libs.kotlin.stdlib)

    testImplementation(platform(libs.test.junitBom))
    testImplementation(libs.test.junitJupiter)
    testImplementation(libs.bundles.test.mockk)
    testImplementation(libs.bundles.ktor.client)
    testImplementation(libs.bundles.test.koin)
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
