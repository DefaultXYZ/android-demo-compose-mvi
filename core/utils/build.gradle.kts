plugins {
    id(Plugins.javaLibrary)
    id(Plugins.kotlinJvm)
    id(Plugins.kotlinKapt)
}

java {
    sourceCompatibility = AndroidConfig.javaVersion
    targetCompatibility = AndroidConfig.javaVersion
}

dependencies {
    implementation(Dependencies.hiltCore)
    kapt(Dependencies.hiltKapt)

    implementation(Dependencies.coroutinesCore)
}
