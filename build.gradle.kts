import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

group = "com.github.nicolas2lee"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}


dependencies {

    implementation("com.amazonaws:aws-lambda-java-events:3.11.1")
    implementation("com.amazonaws:aws-lambda-java-core:1.2.2")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework:spring-context:5.3.26")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}


/*
tasks.withType<Jar> {
    enabled = true
    manifest {
        attributes["Main-Class"] = "com.github.nicolas2lee.example.lambda.spring.minify"
    }
}
 */

tasks["assemble"].dependsOn("shadowJar")


tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
// classifier = "aws"
    dependencies {
        exclude(
            dependency("org.springframework.cloud:spring-cloud-function-web:3.2.9")
        )
    }
// Required for Spring
    mergeServiceFiles()
    append("META-INF/spring.handlers")
    append("META-INF/spring.schemas")
    append("META-INF/spring.tooling")
    transform(com.github.jengelman.gradle.plugins.shadow.transformers.PropertiesFileTransformer::class.java) {
        paths = listOf("META-INF/spring.factories")
        mergeStrategy = "append"
    }
// archiveFileName.set("${project.name}-${project.version}.jar")
}