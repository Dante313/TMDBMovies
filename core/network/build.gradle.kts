import com.example.build_logic.Deps

plugins {
    id("movies.android.library")
    id("movies.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.example.network"

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
    implementation(project(":utils"))

    implementation(Deps.Network.retrofit)
    implementation(Deps.Network.loggingInterceptor)
    implementation(Deps.Network.serializationConverter)
    implementation(Deps.Network.serializationJson)
}