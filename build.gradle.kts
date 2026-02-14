plugins {
    id("java")
    id("application")
    id("io.github.goooler.shadow") version "8.1.8"
}

group = "com.copicraftDev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    // Replace with your fully qualified main class
    mainClass.set("com.copicraftDev.Main")
}

tasks.test {
    useJUnitPlatform()
}
