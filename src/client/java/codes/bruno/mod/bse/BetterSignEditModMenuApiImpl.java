package codes.bruno.mod.bse;

import codes.bruno.mod.bse.gui.ConfigScreen;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.loader.api.FabricLoader;

public class BetterSignEditModMenuApiImpl implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> null;
        // TODO: Uncomment when Cloth Config adds MC 26.1 support
//        return parent -> {
//            var isClothConfigInstalled = FabricLoader.getInstance().isModLoaded("cloth-config");
//
//            return isClothConfigInstalled ? ConfigScreen.create(parent) : null;
//        };
    }
}
