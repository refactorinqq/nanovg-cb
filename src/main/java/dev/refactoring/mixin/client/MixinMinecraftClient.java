package dev.refactoring.mixin.client;

import net.minecraft.client.MinecraftClient;
import org.lwjgl.nanovg.NanoVGGL2;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author refactoring
 */
@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {
    @Inject(method = "initializeGame", at = @At(value = "FIELD", target = "Lnet/minecraft/client/MinecraftClient;inGameHud:Lnet/minecraft/client/gui/hud/InGameHud;"))
    public void mixin$initializeGame(CallbackInfo ci) {
        long cx = NanoVGGL2.nvgCreate(NanoVGGL2.NVG_ANTIALIAS);
        // You need to implement your own thing here.
    }
}
