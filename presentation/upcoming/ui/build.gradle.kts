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
    implementation(project(":presentation:shared:mvi"))
    implementation(project(":presentation:shared:resourcemanagers"))
    implementation(project(":utils"))
    implementation(project(":core:coroutines"))
    implementation(project(":core:network"))
    implementation(project(":presentation:upcoming:domain"))

    implementation(Deps.Hilt.navigation)
    implementation(Deps.Compose.navigation)
    implementation(Deps.Compose.lifecycleRuntime)
    implementation(Deps.Compose.coil)
}