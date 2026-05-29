package net.mars.noweatherskip_mt.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.WeatherData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;



@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin {
    @Shadow
    abstract WeatherData getWeatherData();

    @Inject(method = "Lnet/minecraft/server/level/ServerLevel;resetWeatherCycle()V", at = @At("HEAD"), cancellable = true)
    private void onResetWeatherCycle(CallbackInfo ci) {
        WeatherData weatherData = this.getWeatherData();
        weatherData.setThunderTime(0);
        weatherData.setThundering(false);
        ci.cancel();
    }
}