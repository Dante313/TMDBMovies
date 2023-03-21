import com.example.build_logic.Deps

plugins {
    id("movies.android.application")
    id("movies.android.application.compose")
    id("movies.android.hilt")
}

android {
    namespace = "com.example.tmdbmovies"

    defaultConfig {
        applicationId = "com.example.tmdbmovies"

        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(project(":app-specific:feature:upcoming:ui"))
    implementation(project(":app-specific:feature:upcoming:data"))
    implementation(project(":app-specific:feature:upcoming:domain"))
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation(Deps.Hilt.navigation)

    implementation(Deps.Compose.activity)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}