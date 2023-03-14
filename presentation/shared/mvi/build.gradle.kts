import com.example.build_logic.Deps

plugins {
    id("movies.android.library")
    id("movies.android.library.compose")
}

android {
    namespace = "com.example.mvi"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":core:coroutines"))
    implementation(project(":core:dispatchers"))

    implementation(Deps.Coroutines.android)
    implementation(Deps.Coroutines.core)
}