plugins {
    id("movies.android.library")
    id("movies.android.hilt")
}

android {
    namespace = "com.example.resourcemanagers"

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