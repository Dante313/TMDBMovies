package com.example.build_logic

object Config {

    object Build {

        const val VersionCode = 1
        const val VersionName = "1.0.0"

        const val MinSdk = 23
        const val TargetSdk = 33
        const val CompileSdk = 33

        val JavaVersion = org.gradle.api.JavaVersion.VERSION_11
    }

    object CompilerArgs {

        val KotlinFreeCompilerArgs = listOf(
            "-opt-in=kotlin.RequiresOptIn",
        )
    }
}