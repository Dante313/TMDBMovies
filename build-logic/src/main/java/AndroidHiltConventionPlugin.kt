import com.example.build_logic.Deps
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("dagger.hilt.android.plugin")
            pluginManager.apply("org.jetbrains.kotlin.kapt")

            dependencies {
                "implementation"(Deps.Hilt.android)
                "kapt"(Deps.Hilt.compiler)
                "kaptAndroidTest"(Deps.Hilt.compiler)
            }
        }
    }
}