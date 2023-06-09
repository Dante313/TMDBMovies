buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    id("com.android.application") version "7.4.2" apply false
    id("com.android.library") version "7.4.2" apply false
    kotlin("android") version "1.8.0" apply false
    kotlin("jvm") version "1.8.0" apply false
    id("com.google.dagger.hilt.android") version "2.45" apply false
    kotlin("plugin.serialization") version "1.8.10" apply false
}