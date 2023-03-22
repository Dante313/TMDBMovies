plugins {
    id("movies.android.library")
    id("movies.android.hilt")
}

android {
    namespace = "com.example.details.domain"
}

dependencies {
    implementation(project(":shared:utils"))
}