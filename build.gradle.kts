// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.androidApplication).version(Versions.gradlePlugin).apply(false)
    id(Plugins.kotlinAndroid).version(Versions.kotlin).apply(false)
    id(Plugins.hiltAndroid).version(Versions.hiltAndroid).apply(false)
    id(Plugins.kotlinJvm).version(Versions.kotlin).apply(false)
}
