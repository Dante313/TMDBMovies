import com.example.build_logic.Deps

plugins {
    id("movies.android.library")
    id("movies.android.library.compose")
}

android {
    namespace = "com.example.mvi"
}

dependencies {
    implementation(project(":shared:core:coroutines"))
    implementation(project(":shared:core:dispatchers"))

    implementation(Deps.Coroutines.android)
    implementation(Deps.Coroutines.core)
}