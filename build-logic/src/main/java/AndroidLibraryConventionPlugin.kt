import com.android.build.api.dsl.LibraryExtension
import com.example.build_logic.Deps
import com.example.build_logic.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }
            val extension = extensions.getByType<LibraryExtension>()
            configureKotlinAndroid(extension)

            dependencies {
                "implementation"(Deps.Common.coreKtx)
                "implementation"(Deps.Common.logCat)
                "implementation"(Deps.Common.immutableCollections)
            }
         }
    }
}