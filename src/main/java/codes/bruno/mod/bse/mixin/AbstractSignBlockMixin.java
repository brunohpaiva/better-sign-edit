package codes.bruno.mod.bse.mixin;

import codes.bruno.mod.bse.config.ServerConfig;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.AbstractSignBlock;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractSignBlock.class)
public class AbstractSignBlockMixin {

    @Unique
    private static final ServerConfig serverConfig = ServerConfig.getInstance();

    @ModifyExpressionValue(
        method = "onUse",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/AbstractSignBlock;isTextLiteralOrEmpty(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/block/entity/SignBlockEntity;Z)Z"
        )
    )
    public boolean bse$canEditSign(boolean original, @Local(argsOnly = true) PlayerEntity player) {
        return original && (!serverConfig.isRequireSneakToEdit() || player.isSneaking());
    }

}
