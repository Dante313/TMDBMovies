import com.example.build_logic.Deps

plugins {
    id("movies.android.library")
    id("movies.android.hilt")
}

android {
    namespace = "com.example.coroutines"
}

dependencies {
    implementation(project(":core:dispatchers"))

    implementation(Deps.Coroutines.android)
    implementation(Deps.Coroutines.core)
}