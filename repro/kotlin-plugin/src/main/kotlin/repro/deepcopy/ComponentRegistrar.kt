package repro.deepcopy

import repro.deepcopy.generation.IrExtensionsRepro
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration

class ReproDeepCopyRegistrar @JvmOverloads constructor(
    private val enabled: Boolean = false
): ComponentRegistrar {
    override fun registerProjectComponents(project: MockProject, configuration: CompilerConfiguration) {
        IrGenerationExtension.registerExtension(project, IrExtensionsRepro())
    }

}
