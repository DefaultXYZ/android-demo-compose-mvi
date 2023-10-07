import org.gradle.api.JavaVersion

object AndroidConfig {
    const val applicationId = "com.defaultxyz.demo"
    const val namespace = "com.defaultxyz"

    const val compileSdk = 34
    const val minSdk = 24
    const val targetSdk = compileSdk

    const val versionName = "1.0.0"
    val versionCode = versionName.split(".")
        .mapNotNull { it.toIntOrNull() }
        .takeIf { it.size == 3 }
        ?.joinToString(separator = "") {
            it.toString()
        }?.toIntOrNull().let {
            requireNotNull(it)
        }

    val javaVersion = JavaVersion.VERSION_17

    fun getNamespace(module: String): String {
        return "$namespace.$module"
    }
}
