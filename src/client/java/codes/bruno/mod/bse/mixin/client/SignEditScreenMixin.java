package codes.bruno.mod.bse.mixin.client;

import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.client.gui.screen.ingame.AbstractSignEditScreen;
import net.minecraft.text.Text;
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
public abstract class SignEditScreenMixin {

    @Shadow @Final private String[] messages;

    private String[] initialMessages;

    @Inject(
        method = "<init>(Lnet/minecraft/block/entity/SignBlockEntity;ZZLnet/minecraft/text/Text;)V",
        at = @At("TAIL")
    )
    public void bse$init(SignBlockEntity blockEntity, boolean front, boolean filtered, Text title, CallbackInfo ci) {
        initialMessages = Arrays.copyOf(messages, messages.length);
    }

    @Inject(
        method = "keyPressed",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/screen/Screen;keyPressed(III)Z"
        )
    )
    public void bse$keyPressed(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> cir) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            System.arraycopy(initialMessages, 0, messages, 0, messages.length);
        }
    }

}
