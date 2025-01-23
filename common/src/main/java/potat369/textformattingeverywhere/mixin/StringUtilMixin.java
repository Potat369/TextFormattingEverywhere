package potat369.textformattingeverywhere.mixin;

import net.minecraft.util.StringUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StringUtil.class)
public class StringUtilMixin {
    @Inject(method = "isAllowedChatCharacter", at = @At("RETURN"), cancellable = true)
    private static void isAllowedChatCharacter(char character, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(character != 167 ? cir.getReturnValue() : true);
    }
}