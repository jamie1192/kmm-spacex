buildscript {

    val kotlinVersion = "1.5.10"
    val sqlDelightVersion: String by project

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("com.android.tools.build:gradle:7.0.0-alpha15")

        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")

    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}