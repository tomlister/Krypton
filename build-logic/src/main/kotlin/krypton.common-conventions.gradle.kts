import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("org.cadixdev.licenser")
}

configurations.all {
    exclude("org.checkerframework", "checker-qual")
    exclude("junit")
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
            freeCompilerArgs = listOf("-Xjvm-default=all")
        }
    }
    withType<Test> {
        useJUnitPlatform()
    }
}

tasks["build"].dependsOn(tasks["test"])

license {
    header(project.rootProject.resources.text.fromFile("HEADER.txt"))
    newLine(false)
}
