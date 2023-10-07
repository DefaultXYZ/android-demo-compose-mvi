plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.hiltAndroid)
}

android {
    namespace = AndroidConfig.getNamespace("demo")
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
    implementation(project(Modules.login))
    implementation(project(Modules.featureA))
    implementation(project(Modules.featureB))
    implementation(project(Modules.featureC))
    implementation(project(Modules.coreUI))

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycleKtx)
    implementation(Dependencies.viewModelKtx)
    implementation(Dependencies.activity)
    implementation(platform(Dependencies.platformCompose))
    implementation(Dependencies.composeUI)
    implementation(Dependencies.composeUIGraphics)
    implementation(Dependencies.composeUIToolingPreview)
    implementation(Dependencies.composeMaterial)
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
