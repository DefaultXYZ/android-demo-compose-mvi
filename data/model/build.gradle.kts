plugins {
    id(Plugins.javaLibrary)
    id(Plugins.kotlinJvm)
}

java {
    sourceCompatibility = AndroidConfig.javaVersion
    targetCompatibility = AndroidConfig.javaVersion
}
