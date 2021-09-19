package repro.deepcopy.generation

import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.IrStatement
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.ir.declarations.IrSimpleFunction
import org.jetbrains.kotlin.ir.util.deepCopyWithSymbols
import org.jetbrains.kotlin.ir.visitors.IrElementTransformerVoid
import org.jetbrains.kotlin.ir.visitors.transformChildrenVoid

class IrExtensionsRepro : IrGenerationExtension {
    override fun generate(moduleFragment: IrModuleFragment, pluginContext: IrPluginContext) {
        throw IllegalStateException("Should be here when compiling")
        moduleFragment.transformChildrenVoid(object : IrElementTransformerVoid() {
            override fun visitSimpleFunction(declaration: IrSimpleFunction): IrStatement {
//                if (!declaration.name.asString().equals("MyRadioGroup")) {
//                    return declaration
//                }
                return declaration.deepCopyWithSymbols(
                    initialParent = declaration.parent
                ).also { copiedFun ->
//                    println(JsManglerDesc.getMangleComputer(MangleMode.FULL).computeMangle(copiedFun.descriptor))
                }
            }
        })
    }
}
