package com.example.build_logic

import com.android.build.api.dsl.ApplicationExtension

internal fun configureAndroidApplication(
    applicationExtension: ApplicationExtension
) {
    applicationExtension.apply {
        defaultConfig {
            versionCode = Config.Build.VersionCode
            versionName = Config.Build.VersionName
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }
}