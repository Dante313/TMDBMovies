import com.example.build_logic.Deps

plugins {
    id("movies.android.library")
    id("movies.android.hilt")
}

android {
    namespace = "com.example.dispatchers"

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
    implementation(Deps.Coroutines.android)
    implementation(Deps.Coroutines.core)
}