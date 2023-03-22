import com.example.build_logic.Deps

plugins {
    id("movies.android.library")
    id("movies.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.example.upcoming.data"
}

dependencies {
    implementation(project(":shared:core:network"))
    implementation(project(":app-specific:feature:upcoming:domain"))

    implementation(Deps.Network.serializationJson)
    implementation(Deps.Network.retrofit)
}