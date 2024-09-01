plugins {
    id("java")
    id("dev.architectury.loom") version("1.5-SNAPSHOT")
    id("architectury-plugin") version("3.4-SNAPSHOT")
    kotlin("jvm") version ("1.7.10")
}

group = properties["group"]!!
version = properties["mod_version"]!!

architectury {
    platformSetupLoomIde()
    fabric()
}

loom {
}

repositories {
    mavenCentral()
    maven("https://maven.impactdev.net/repository/development/")
    maven("https://maven.nucleoid.xyz")
}

dependencies {
    minecraft("com.mojang:minecraft:${properties["mc_version"]}")
    mappings("net.fabricmc:yarn:${properties["yarn_version"]}")
    modImplementation("net.fabricmc:fabric-loader:0.15.10")

    modImplementation(include("eu.pb4","polymer-core", properties["polymer_version"].toString()))
    modImplementation(include("eu.pb4","polymer-blocks", properties["polymer_version"].toString()))
    modImplementation(include("eu.pb4","polymer-resource-pack", properties["polymer_version"].toString()))
    modImplementation(include("eu.pb4","polymer-virtual-entity", properties["polymer_version"].toString()))

    modImplementation("net.fabricmc.fabric-api:fabric-api:${properties["fabric_version"]}")
    modImplementation("com.cobblemon:fabric:${properties["cobblemon_version"]}")
}

tasks.processResources {
    inputs.property("version", project.version)

    filesMatching("fabric.mod.json") {
        expand(project.properties)
    }
}