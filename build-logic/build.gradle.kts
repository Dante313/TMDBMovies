plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    compileOnly("com.android.tools.build:gradle:7.4.2")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "movies.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "movies.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("kotlinLibrary") {
            id = "movies.kotlin.library"
            implementationClass = "KotlinLibraryConventionPlugin"
        }
        register("androidHilt") {
            id = "movies.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "movies.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "movies.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
    }
}