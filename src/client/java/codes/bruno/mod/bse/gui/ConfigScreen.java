package codes.bruno.mod.bse.gui;

import codes.bruno.mod.bse.BetterSignEditModClient;
import codes.bruno.mod.bse.config.ClientConfig;
//import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.io.IOException;

public class ConfigScreen {

    // TODO: Uncomment when Cloth Config adds MC 26.1 support
//    public static Screen create(Screen parent) {
//        var clientConfig = ClientConfig.getInstance();
//
//        var builder = ConfigBuilder.create()
//            .setParentScreen(parent)
//            .setTitle(Component.translatable("text.better-sign-edit.config.title"));
//
//        var entryBuilder = builder.entryBuilder();
//
//        var generalCategory = builder.getOrCreateCategory(Component.literal("General"));
//
//        generalCategory.addEntry(
//            entryBuilder.startBooleanToggle(
//                    Component.translatable("text.better-sign-edit.config.option.saveChangesWithEscape"),
//                    clientConfig.isSaveChangesWithEscape()
//                )
//                .setDefaultValue(false)
//                .setSaveConsumer(saveChangesWithEscape -> {
//                    clientConfig.setSaveChangesWithEscape(saveChangesWithEscape);
//                    try {
//                        clientConfig.saveToFile();
//                    } catch (IOException e) {
//                        BetterSignEditModClient.LOGGER.error("Couldn't save the client config file", e);
//                    }
//                })
//                .build()
//        );
//
//        return builder.build();
//    }

}
