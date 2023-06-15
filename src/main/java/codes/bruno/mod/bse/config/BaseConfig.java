package codes.bruno.mod.bse.config;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public abstract class BaseConfig {

    private static final String BASE_MOD_CONFIG_FOLDER = "better-sign-edit";

    private final Properties properties = new Properties();
    private final Path filePath;

    public BaseConfig(String fileName) {
        this.filePath = Path.of("config", BASE_MOD_CONFIG_FOLDER, fileName);
    }

    public void loadFromFile() throws IOException {
        var file = filePath.toFile();
        file.getParentFile().mkdirs();

        if (!file.exists()) {
            try (var is = this.getClass().getResourceAsStream("/default-" + this.filePath.getFileName())) {
                Files.copy(is, this.filePath);
            }
        }

        try (var br = Files.newBufferedReader(this.filePath, StandardCharsets.UTF_8)) {
            this.properties.load(br);
        }

        this.loadProperties(this.properties);
    }

    public void saveToFile() throws IOException {
        this.saveProperties(this.properties);

        try (var bw = Files.newBufferedWriter(this.filePath, StandardCharsets.UTF_8)) {
            this.properties.store(bw, null);
        }
    }

    abstract void loadProperties(Properties properties);

    abstract void saveProperties(Properties properties);

}
