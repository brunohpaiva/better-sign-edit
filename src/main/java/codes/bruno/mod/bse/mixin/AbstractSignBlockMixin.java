package codes.bruno.mod.bse.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.block.AbstractSignBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractSignBlock.class)
public class AbstractSignBlockMixin {

    @ModifyExpressionValue(
        method = "onUse",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/AbstractSignBlock;isTextLiteralOrEmpty(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/block/entity/SignBlockEntity;Z)Z"
        )
    )
    public boolean bse$canEditSign(
        boolean original,
        BlockState state,
        World world,
        BlockPos pos,
        PlayerEntity player,
        Hand hand,
        BlockHitResult hit
    ) {
        return original && player.isSneaking();
    }

}
