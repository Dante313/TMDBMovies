plugins {
    id("movies.android.library")
    id("movies.android.hilt")
}

android {
    namespace = "com.example.upcoming.domain"
}
dependencies {
    api(project(":shared:core:domain:errors"))
}