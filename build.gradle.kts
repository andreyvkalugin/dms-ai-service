plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.5.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "ru.kalugin"
version = "0.0.1-SNAPSHOT"
description = "ai project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("chat.giga:gigachat-java:0.1.10")
	//implementation("dev.langchain4j:langchain4j-spring-boot-starter:1.4.0")
	//implementation("dev.langchain4j:langchain4j:1.1.0")
	implementation("org.bsc.langgraph4j:langgraph4j-spring-ai:1.6.2")
	implementation("dev.langchain4j:langchain4j-spring-boot-starter:1.4.0-beta10")
	implementation("chat.giga:langchain4j-gigachat-spring-boot-starter:0.1.13")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
