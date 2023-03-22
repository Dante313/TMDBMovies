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
include(":shared:feature:mvi")
include(":shared:core:coroutines")
include(":shared:core:dispatchers")
include(":shared:core:network")
include(":shared:feature:resourcemanagers")
include(":shared:utils")
include(":app-specific:feature:upcoming:data")
include(":app-specific:feature:upcoming:domain")
include(":app-specific:feature:upcoming:ui")
include(":app-specific:feature:details:data")
include(":app-specific:feature:details:domain")
include(":shared:core:domain:errors")
include(":shared:core:data:errors")
