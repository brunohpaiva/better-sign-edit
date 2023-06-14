package codes.bruno.mod.bse;

import com.llamalad7.mixinextras.MixinExtrasBootstrap;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterSignEditMod implements ModInitializer, PreLaunchEntrypoint {
    public static final Logger LOGGER = LoggerFactory.getLogger("better-sign-edit");

    @Override
    public void onPreLaunch() {
        MixinExtrasBootstrap.init();
    }

    @Override
    public void onInitialize() {
        LOGGER.info("Better Sign Edit initialized");
    }
}