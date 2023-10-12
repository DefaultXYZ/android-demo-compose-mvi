plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
}

android {
    namespace = AndroidConfig.getNamespace("domain")
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
}

dependencies {
    implementation(project(Modules.dataModel))
    implementation(project(Modules.dataStore))

    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltKapt)

    implementation(Dependencies.coroutinesAndroid)

    testImplementation(Dependencies.junit)

    androidTestImplementation(Dependencies.androidxJunit)
    androidTestImplementation(Dependencies.espresso)
}
