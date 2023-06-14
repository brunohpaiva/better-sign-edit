package codes.bruno.mod.bse;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterSignEditMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("better-sign-edit");

    @Override
    public void onInitialize() {
        LOGGER.info("Better Sign Edit initialized");
    }
}