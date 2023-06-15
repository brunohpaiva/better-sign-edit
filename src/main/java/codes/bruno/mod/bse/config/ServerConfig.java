package codes.bruno.mod.bse.config;

import java.util.Properties;

public class ServerConfig extends BaseConfig {

    private static ServerConfig instance;

    private boolean requireSneakToEdit = true;

    public ServerConfig() {
        super("server-config.properties");
    }

    @Override
    void loadProperties(Properties properties) {
        this.requireSneakToEdit = Boolean.parseBoolean(properties.getProperty("requireSneakToEdit", "true"));
    }

    @Override
    void saveProperties(Properties properties) {
        properties.setProperty("requireSneakToEdit", Boolean.toString(this.requireSneakToEdit));
    }

    public boolean isRequireSneakToEdit() {
        return requireSneakToEdit;
    }

    public static ServerConfig getInstance() {
        if (instance == null) {
            instance = new ServerConfig();
        }
        return instance;
    }
}
