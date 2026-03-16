package codes.bruno.mod.bse.mixin.client;

import codes.bruno.mod.bse.config.ClientConfig;
import net.minecraft.client.gui.screens.inventory.AbstractSignEditScreen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;

@Mixin(AbstractSignEditScreen.class)
public class SignEditScreenMixin {

    private static final ClientConfig clientConfig = ClientConfig.getInstance();

    @Shadow @Final private String[] messages;

    private String[] initialMessages;

    @Inject(
        method = "<init>(Lnet/minecraft/world/level/block/entity/SignBlockEntity;ZZLnet/minecraft/network/chat/Component;)V",
        at = @At("TAIL")
    )
    public void bse$init(SignBlockEntity blockEntity, boolean front, boolean filtered, Component title, CallbackInfo ci) {
        if (!clientConfig.isSaveChangesWithEscape()) {
            initialMessages = Arrays.copyOf(messages, messages.length);
        }
    }

    @Inject(
        method = "keyPressed",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/screens/Screen;keyPressed(Lnet/minecraft/client/input/KeyEvent;)Z"
        )
    )
    public void bse$keyPressed(KeyEvent input, CallbackInfoReturnable<Boolean> cir) {
        if (!clientConfig.isSaveChangesWithEscape() && input.key() == GLFW.GLFW_KEY_ESCAPE) {
            System.arraycopy(initialMessages, 0, messages, 0, messages.length);
        }
    }

}
