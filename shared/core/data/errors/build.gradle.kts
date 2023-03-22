plugins {
    id("movies.android.library")
    id("movies.android.hilt")

}

android {
    namespace = "com.example.errors"

}

dependencies {
    implementation(project(":shared:core:domain:errors"))
    implementation(com.example.build_logic.Deps.Network.retrofit)
}