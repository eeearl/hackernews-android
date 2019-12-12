import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.compileSdk)

    defaultConfig {
        applicationId = "com.eeearl.hackernews"
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = Versions.code
        versionName = Versions.name
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin(Dependencies.Kotlin.stdLib, KotlinCompilerVersion.VERSION))

    // Android
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.ktx)
    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.AndroidX.recyclerView)

    // Netowkring
    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.okhttp)

    // Koin
    implementation(Dependencies.Koin.core)
    implementation(Dependencies.Koin.android)
    implementation(Dependencies.Koin.viewmodel)
    implementation(Dependencies.Koin.arch)

    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.AndroidX.Test.runner)
    androidTestImplementation(Dependencies.AndroidX.Test.espresso)
}

androidExtensions {
    isExperimental = true
}