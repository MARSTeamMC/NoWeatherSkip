package net.mars.noweatherskip_mt.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.storage.ServerLevelData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin {
    @Shadow
    @Final
    private ServerLevelData serverLevelData;

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;resetWeatherCycle()V"))
    private void redirectResetWeatherCycle(ServerLevel instance) {
        if (this.serverLevelData.isThundering()) {
            this.serverLevelData.setThundering(false);
            this.serverLevelData.setThunderTime(0);
        }
    }
}
