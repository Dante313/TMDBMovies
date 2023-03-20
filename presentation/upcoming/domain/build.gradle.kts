plugins {
    id("movies.android.library")
    id("movies.android.hilt")
}

android {
    namespace = "com.example.upcoming.domain"

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
    implementation(project(":utils"))
}