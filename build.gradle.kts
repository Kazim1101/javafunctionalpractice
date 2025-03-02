plugins {
    id("java")
}

group = "org.functionalprogramming"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    compileOnly("org.projectlombok:lombok:1.18.30") // Use latest version
    implementation("ch.qos.logback:logback-classic:1.4.14")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    compileOnly(platform("com.fasterxml.jackson:jackson-bom:2.13.4"))
//    implementation("com.fasterxml.jackson.core:jackson-core")
    compileOnly("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}