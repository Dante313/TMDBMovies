package com.example.build_logic

object Deps {

    object Compose {
        const val compilerVersion = "1.4.0"
        private const val version = "1.3.3"

        const val activity = "androidx.activity:activity-compose:1.3.1"
        const val ui = "androidx.compose.ui:ui:$version"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val material3 = "androidx.compose.material3:material3:1.1.0-alpha08"

        const val uiTestJUnit4 = "androidx.compose.ui:ui-test-junit4:$version"
        const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
        const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:$version"
    }

    object Hilt {
        private const val version = "2.45"

        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val navigation = "'androidx.hilt:hilt-navigation-compose:1.0.0'"
    }

    object Common {
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val logCat = "com.squareup.logcat:logcat:0.1"
        const val immutableCollections = "org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    }

    object Coroutines {
        private const val version = "1.7.0-Beta"

        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    }

    object Network {
        const val retrofit= "com.squareup.retrofit2:retrofit:2.9.0"
        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0"
        const val serializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.10.0"
    }
}