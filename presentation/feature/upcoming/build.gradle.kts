import com.example.build_logic.Deps

plugins {
    id("movies.android.library")
    id("movies.android.hilt")
    id("movies.android.library.compose")
}

android {
    namespace = "com.example.upcoming"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":presentation:shared:mvi"))
    implementation(project(":core:data"))
    implementation(project(":presentation:shared:resourcemanagers"))
    implementation(project(":utils"))
    implementation(project(":core:coroutines"))

    implementation(Deps.Hilt.navigation)
    implementation(Deps.Compose.navigation)
    implementation(Deps.Compose.lifecycleRuntime)
    implementation(Deps.Compose.coil)
}