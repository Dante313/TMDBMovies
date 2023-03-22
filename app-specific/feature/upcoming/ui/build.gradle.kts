import com.example.build_logic.Deps

plugins {
    id("movies.android.library")
    id("movies.android.hilt")
    id("movies.android.library.compose")
}

android {
    namespace = "com.example.upcoming.ui"
}

dependencies {
    implementation(project(":shared:feature:mvi"))
    implementation(project(":shared:feature:resourcemanagers"))
    implementation(project(":shared:core:coroutines"))
    implementation(project(":shared:core:network"))
    implementation(project(":app-specific:feature:upcoming:domain"))

    implementation(Deps.Hilt.navigation)
    implementation(Deps.Compose.navigation)
    implementation(Deps.Compose.lifecycleRuntime)
    implementation(Deps.Compose.coil)
}