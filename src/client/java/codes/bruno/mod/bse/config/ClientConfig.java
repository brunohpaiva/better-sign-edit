package codes.bruno.mod.bse.config;

import java.util.Properties;

public class ClientConfig extends BaseConfig {

    private static ClientConfig instance;

    private boolean saveChangesWithEscape = false;

    public ClientConfig() {
        super("client-config.properties");
    }

    @Override
    void loadProperties(Properties properties) {
        this.saveChangesWithEscape = Boolean.parseBoolean(properties.getProperty("saveChangesWithEscape", "false"));
    }

    @Override
    void saveProperties(Properties properties) {
        properties.setProperty("saveChangesWithEscape", Boolean.toString(this.saveChangesWithEscape));
    }

    public boolean isSaveChangesWithEscape() {
        return saveChangesWithEscape;
    }

    public void setSaveChangesWithEscape(boolean saveChangesWithEscape) {
        this.saveChangesWithEscape = saveChangesWithEscape;
    }

    public static ClientConfig getInstance() {
        if (instance == null) {
            instance = new ClientConfig();
        }
        return instance;
    }
}
