package dev.refactoring.mixin.lwjgl;

import dev.refactoring.prov.Lwjgl2FunctionProvider;
import org.spongepowered.asm.mixin.Mixin;


import org.lwjgl.system.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

/**
 * This class is only required in legacy versions which use LWJGL 2.
 *
 * @author refactoring
 */
@Mixin(targets = "org.lwjgl.nanovg.NanoVGGLConfig")
public abstract class MixinNanoVGGLConfig {
    @Inject(method = "getFunctionProvider", at = @At("HEAD"),
            cancellable = true, remap = false)
    private static void getFunctionProvider(String className, CallbackInfoReturnable<FunctionProvider> cir) {
        cir.setReturnValue(new Lwjgl2FunctionProvider());
    }
}