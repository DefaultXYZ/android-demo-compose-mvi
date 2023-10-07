pluginManagement {
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

rootProject.name = "Demo Compose"
include(":app")
include(":presentation:feature-a")
include(":presentation:feature-b")
include(":presentation:feature-c")
include(":presentation:login")
include(":core:ui")
