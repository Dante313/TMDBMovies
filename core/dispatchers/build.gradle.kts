import com.example.build_logic.Deps

plugins {
    id("movies.android.library")
    id("movies.android.hilt")
}

android {
    namespace = "com.example.dispatchers"
}

dependencies {
    implementation(Deps.Coroutines.android)
    implementation(Deps.Coroutines.core)
}