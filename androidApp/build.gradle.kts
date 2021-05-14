plugins {
    id("com.android.application")
    kotlin("android")
}

val composeVersion = "1.0.0-beta01"

dependencies {
    // default dependencies
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    // SpaceX dependencies
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    implementation("androidx.core:core-ktx:1.3.1")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.cardview:cardview:1.0.0")

    // Jetpack Compose dependencies
//    implementation("androidx.compose.compiler:compiler:$composeVersion")
//    implementation("androidx.compose.ui:ui:$composeVersion")
//    // Tooling support (Previews, etc.)
//    implementation( "androidx.compose.ui:ui-tooling:$composeVersion")
//    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
//    implementation("androidx.compose.foundation:foundation:$composeVersion")
//    // Material Design
//    implementation("androidx.compose.material:material:$composeVersion")
//    // Material design icons
//    implementation("androidx.compose.material:material-icons-core:$composeVersion")
//    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
//    // Integration with activities
//    implementation("androidx.activity:activity-compose:1.3.0-alpha03")
//    // Integration with ViewModels
//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha02")
//    // Integration with observables
//    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
//    implementation("androidx.compose.runtime:runtime-rxjava2:$composeVersion")

}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.jastley.innovationday.android"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
//        compose = true
    }
    // Set both the Java and Kotlin compilers to target Java 8.

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

//    composeOptions {
//        kotlinCompilerExtensionVersion = "0.1.0-dev13"
//        kotlinCompilerVersion = "1.3.70-dev-withExperimentalGoogleExtensions-20200424"
//    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
