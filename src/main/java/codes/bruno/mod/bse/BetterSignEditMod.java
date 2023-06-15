package codes.bruno.mod.bse;

import codes.bruno.mod.bse.config.ServerConfig;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class BetterSignEditMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("better-sign-edit");

    @Override
    public void onInitialize() {
        try {
            ServerConfig.getInstance().loadFromFile();
        } catch (IOException e) {
            LOGGER.error("Couldn't load the server config file", e);
        }

        LOGGER.info("Better Sign Edit initialized");
    }
}