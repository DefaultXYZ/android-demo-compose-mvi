plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
}

android {
    namespace = AndroidConfig.getNamespace("splash")
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = AndroidConfig.javaVersion
        targetCompatibility = AndroidConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = AndroidConfig.javaVersion.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {
    implementation(project(Modules.domain))
    implementation(project(Modules.coreUI))
    implementation(project(Modules.coreLocalisation))
    implementation(project(Modules.coreUtils))

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycleCompose)
    implementation(Dependencies.lifecycleKtx)
    implementation(Dependencies.viewModelKtx)
    implementation(Dependencies.activity)
    implementation(platform(Dependencies.platformCompose))
    implementation(Dependencies.composeUI)
    implementation(Dependencies.composeUIGraphics)
    implementation(Dependencies.composeUIToolingPreview)
    implementation(Dependencies.composeMaterial3)

    implementation(Dependencies.hiltAndroid)
    implementation(Dependencies.hiltNavigation)
    kapt(Dependencies.hiltKapt)

    implementation(Dependencies.coroutinesAndroid)

    debugImplementation(Dependencies.composeDebugUITooling)
    debugImplementation(Dependencies.composeDebugUITestManifest)

    testImplementation(Dependencies.junit)

    androidTestImplementation(Dependencies.androidxJunit)
    androidTestImplementation(Dependencies.espresso)
    androidTestImplementation(platform(Dependencies.platformCompose))
    androidTestImplementation(Dependencies.composeUITestJunit)
}
