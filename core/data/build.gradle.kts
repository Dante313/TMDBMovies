import com.example.build_logic.Deps

plugins {
    id("movies.android.library")
    id("movies.android.hilt")
}

android {
    namespace = "com.example.data"

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
    implementation(project(":core:network"))
    implementation(project(":utils"))

    implementation(Deps.Network.retrofit)
    implementation(Deps.Coroutines.android)
    implementation(Deps.Coroutines.core)
    implementation(Deps.Paging.runtime)
}