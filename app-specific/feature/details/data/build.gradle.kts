import com.example.build_logic.Deps

plugins {
    id("movies.android.library")
    id("movies.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.example.details.data"
}

dependencies {
    implementation(project(":shared:core:network"))
    implementation(project(":shared:utils"))

    implementation(Deps.Network.serializationJson)
    implementation(Deps.Network.retrofit)
}