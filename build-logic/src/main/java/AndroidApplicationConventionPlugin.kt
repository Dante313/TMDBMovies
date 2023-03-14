import com.android.build.api.dsl.ApplicationExtension
import com.example.build_logic.Deps
import com.example.build_logic.configureAndroidApplication
import com.example.build_logic.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<ApplicationExtension> {
                configureAndroidApplication(this)
                configureKotlinAndroid(this)
            }
            dependencies {
                "implementation"(Deps.Common.coreKtx)
                "implementation"(Deps.Common.lifecycleRuntimeKtx)
                "implementation"(Deps.Common.logCat)
            }
        }
    }
}