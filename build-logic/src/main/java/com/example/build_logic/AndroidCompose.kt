package com.example.build_logic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *>
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = Deps.Compose.compilerVersion
        }
        dependencies {
            "implementation"(Deps.Compose.ui)
            "implementation"(Deps.Compose.uiToolingPreview)
            "implementation"(Deps.Compose.material3)

            "androidTestImplementation"(Deps.Compose.uiTestJUnit4)
            "debugImplementation"(Deps.Compose.uiTooling)
            "debugImplementation"(Deps.Compose.uiTestManifest)
        }
    }
}