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
include(":presentation:login")
include(":presentation:feature-a")
include(":presentation:feature-b")
include(":presentation:feature-c")
include(":domain")
include(":data:store")
include(":data:model")
include(":core:ui")
include(":core:utils")
