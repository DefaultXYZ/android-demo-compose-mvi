plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.hiltAndroid)
}

android {
    namespace = AndroidConfig.namespace
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycleKtx)
    implementation(Dependencies.viewModelKtx)
    implementation(Dependencies.activity)
    implementation(platform(Dependencies.platformCompose))
    implementation(Dependencies.composeUI)
    implementation(Dependencies.composeUIGraphics)
    implementation(Dependencies.composeUIToolingPreview)
    implementation(Dependencies.composeMaterial)

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
