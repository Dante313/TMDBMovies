package com.example.build_logic

import org.gradle.api.plugins.JavaPluginExtension

internal fun configureKotlinLibrary(
    javaPluginExtension: JavaPluginExtension
) {
    javaPluginExtension.apply {
        sourceCompatibility = Config.Build.JavaVersion
        targetCompatibility = Config.Build.JavaVersion
    }
}