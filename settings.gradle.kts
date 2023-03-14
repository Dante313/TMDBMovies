pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "TMDBMovies"
include(":app")
include(":presentation:shared:mvi")
include(":core:coroutines")
include(":core:dispatchers")
include(":core:network")
include(":core:data")
include(":presentation:feature:upcoming")
include(":business:usecases:upcoming")
