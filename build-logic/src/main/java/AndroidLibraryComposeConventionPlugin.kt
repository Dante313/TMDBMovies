import com.android.build.api.dsl.LibraryExtension
import com.example.build_logic.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val extensions = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extensions)
        }
    }
}