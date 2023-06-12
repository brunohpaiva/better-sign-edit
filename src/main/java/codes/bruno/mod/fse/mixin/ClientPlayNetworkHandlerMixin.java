package codes.bruno.mod.fse.mixin;

import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {

    @Shadow @Final private MinecraftClient client;

    @Inject(
        method = "sendPacket(Lnet/minecraft/network/packet/Packet;)V",
        at = @At("HEAD"),
        cancellable = true
    )
    private void fse$sendPacket(Packet<?> packet, CallbackInfo ci) {
        if (
            packet instanceof PlayerInteractBlockC2SPacket interaction
            && !client.player.isSneaking()
            && client.world.getBlockEntity(interaction.getBlockHitResult().getBlockPos()) instanceof SignBlockEntity
        ) {
            ci.cancel();
        }
    }

}
