plugins {
    java
    id("io.quarkus")

    // https://plugins.gradle.org/plugin/org.flywaydb.flyway
    id("org.flywaydb.flyway") version "9.16.2"
    id("io.freefair.lombok") version "8.4"
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-resteasy-reactive")
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson")
    implementation("io.quarkus:quarkus-config-yaml")
    implementation("com.google.guava:guava")
    implementation("io.quarkus:quarkus-hibernate-validator")

    // Database
    implementation("io.quarkus:quarkus-hibernate-orm")
    implementation("io.quarkus:quarkus-jdbc-postgresql")
    implementation("io.quarkus:quarkus-flyway:${quarkusPlatformVersion}")
    implementation("io.quarkus:quarkus-hibernate-orm-panache")

    // Openapi
    implementation("io.quarkus:quarkus-smallrye-openapi")

    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")

    compileOnly("org.projectlombok:lombok:0.11.0")
}

group = "com.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}
