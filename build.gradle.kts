plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.5"
    id("com.github.ben-manes.versions") version "0.54.0"
    id("se.patrikerdes.use-latest-versions") version "0.2.19"
}

group = "com.dnyferguson"
version = "3.1.7"

java {
    sourceCompatibility = JavaVersion.VERSION_16
    targetCompatibility = JavaVersion.VERSION_16
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://jitpack.io")
    maven("https://repo.codemc.org/repository/maven-public/")
    maven("https://repository.apache.org/snapshots/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:26.1.2-R0.1-SNAPSHOT")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
    implementation("de.tr7zw:item-nbt-api:2.15.7")
    implementation("com.github.cryptomorin:XSeries:13.7.0")
}

tasks.shadowJar {
    archiveClassifier.set("")

    relocate("de.tr7zw.changeme.nbtapi", "com.dnyferguson.mineablespawners.nbtapi")
    relocate("com.cryptomorin.xseries", "com.dnyferguson.mineablespawners.xseries")
}

tasks.build {
    dependsOn(tasks.shadowJar)
}
