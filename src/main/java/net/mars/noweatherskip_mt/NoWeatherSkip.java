package net.mars.noweatherskip_mt;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NoWeatherSkip implements ModInitializer {
	public static final String MOD_ID = "noweatherskip_mt";
	public static final double MDECILLION = Math.pow(10, 256);

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModContainer mod = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(null);
		String version = mod.getMetadata().getVersion().getFriendlyString();

		LOGGER.info("[{}] v{} initialized by MARS Team.", MOD_ID, version);

	}
}