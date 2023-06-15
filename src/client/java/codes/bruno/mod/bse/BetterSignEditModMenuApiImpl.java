package codes.bruno.mod.bse;

import codes.bruno.mod.bse.config.ClientConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.minecraft.text.Text;

import java.io.IOException;

public class BetterSignEditModMenuApiImpl implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        var clientConfig = ClientConfig.getInstance();

        return parent -> {
            var builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.translatable("text.better-sign-edit.config.title"));

            var entryBuilder = builder.entryBuilder();

            var generalCategory = builder.getOrCreateCategory(Text.of("General"));

            generalCategory.addEntry(
                entryBuilder.startBooleanToggle(
                        Text.translatable("text.better-sign-edit.config.option.saveChangesWithEscape"),
                        clientConfig.isSaveChangesWithEscape()
                    )
                    .setDefaultValue(false)
                    .setSaveConsumer(saveChangesWithEscape -> {
                        clientConfig.setSaveChangesWithEscape(saveChangesWithEscape);
                        try {
                            clientConfig.saveToFile();
                        } catch (IOException e) {
                            BetterSignEditModClient.LOGGER.error("Couldn't save the client config file", e);
                        }
                    })
                    .build()
            );

            return builder.build();
        };
    }
}
