package potat369.textformattingeverywhere.mixin;

import net.minecraft.util.StringUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StringUtil.class)
public class StringUtilMixin {
    // Prior to 1.20.9
    @Inject(method = "isAllowedChatCharacter(C)Z", at = @At("RETURN"), cancellable = true)
    private static void isAllowedChatCharacter(char character, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(character != 167 ? cir.getReturnValue() : true);
    }

    // After 1.20.9
    @Inject(method = "method_57175(I)Z", remap = false, at = @At("RETURN"), cancellable = true)
    private static void isAllowedChatCharacterInt(int character, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(character != 167 ? cir.getReturnValue() : true);
    }
}