package codes.bruno.mod.bse.mixin;

import codes.bruno.mod.bse.config.ServerConfig;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.SignBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SignBlock.class)
public class AbstractSignBlockMixin {

    @Unique
    private static final ServerConfig serverConfig = ServerConfig.getInstance();

    @ModifyExpressionValue(
        method = "useWithoutItem",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/block/SignBlock;hasEditableText(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/level/block/entity/SignBlockEntity;Z)Z"
        )
    )
    public boolean bse$canEditSign(boolean original, @Local(argsOnly = true) Player player) {
        return original && (!serverConfig.isRequireSneakToEdit() || player.isShiftKeyDown());
    }

}
