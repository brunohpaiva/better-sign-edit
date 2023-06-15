package codes.bruno.mod.bse;

import codes.bruno.mod.bse.config.ClientConfig;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class BetterSignEditModClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("better-sign-edit");

	@Override
	public void onInitializeClient() {
		try {
			ClientConfig.getInstance().loadFromFile();
		} catch (IOException e) {
			LOGGER.error("Couldn't load the client config file", e);
		}
	}
}