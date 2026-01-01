plugins {
    id("java")
    id("application") // <-- Added for gradle run
}

group = "com.copicraftDev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1") // <-- Added Gson

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
