import com.example.build_logic.Deps
import java.io.FileInputStream
import java.util.Properties

plugins {
    id("movies.android.library")
    id("movies.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.example.network"

    defaultConfig {
        val propertiesFile = project.rootProject.file("local.properties")
        val properties = loadSigningProperties(propertiesFile)

        buildConfigField(
            type = "String",
            name = "API_KEY",
            value = properties.getProperty("API_KEY")
        )
    }
}

fun loadSigningProperties(file: File) =
    Properties().apply {
        load(FileInputStream(file))
    }

dependencies {
    implementation(project(":shared:utils"))

    implementation(Deps.Network.retrofit)
    implementation(Deps.Network.loggingInterceptor)
    implementation(Deps.Network.serializationConverter)
    implementation(Deps.Network.serializationJson)
}