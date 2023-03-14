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
}