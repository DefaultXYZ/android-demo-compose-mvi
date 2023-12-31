object Versions {
    const val gradlePlugin = "8.1.2"
    const val kotlin = "1.8.10"
    const val hiltAndroid = "2.48.1"

    const val lifecycle = "2.6.2"
    const val room = "2.5.2"
    const val coroutines = "1.7.3"
}

object Dependencies {
    const val coreKtx = "androidx.core:core-ktx:1.12.0"
    const val lifecycleCompose = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycle}"
    const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val activity = "androidx.activity:activity-compose:1.7.2"

    const val platformCompose = "androidx.compose:compose-bom:2023.03.00"
    const val composeUI = "androidx.compose.ui:ui"
    const val composeUIGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUIToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeMaterial = "androidx.compose.material:material:1.5.3"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeDebugUITooling = "androidx.compose.ui:ui-tooling"
    const val composeDebugUITestManifest = "androidx.compose.ui:ui-test-manifest"

    const val navigationCompose = "androidx.navigation:navigation-compose:2.7.3"

    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomKapt = "androidx.room:room-compiler:${Versions.room}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
    const val hiltCore = "com.google.dagger:hilt-core:${Versions.hiltAndroid}"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
    const val hiltKapt = "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroid}"

    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:${Versions.coroutines}"

    const val junit = "junit:junit:4.13.2"
    const val androidxJunit = "androidx.test.ext:junit:1.1.5"
    const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
    const val composeUITestJunit = "androidx.compose.ui:ui-test-junit4"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val javaLibrary = "java-library"
    const val kotlinJvm = "org.jetbrains.kotlin.jvm"
    const val kotlinKapt = "kotlin-kapt"
    const val hiltAndroid = "com.google.dagger.hilt.android"
}

object Modules {
    const val splash = ":presentation:splash"
    const val login = ":presentation:login"
    const val featureA = ":presentation:feature-a"
    const val featureB = ":presentation:feature-b"
    const val featureC = ":presentation:feature-c"
    const val domain = ":domain"
    const val dataStore = ":data:store"
    const val dataModel = ":data:model"
    const val coreUI = ":core:ui"
    const val coreLocalisation = ":core:localisation"
    const val coreUtils = ":core:utils"
}
