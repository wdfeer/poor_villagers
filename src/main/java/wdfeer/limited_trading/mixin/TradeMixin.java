package wdfeer.limited_trading.mixin;

import net.minecraft.village.TradeOffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TradeOffer.class)
public class TradeMixin {
    @Shadow
    private int uses;

    @Inject(at = @At("HEAD"), method = "use")
	private void use(CallbackInfo info) {
       this.uses++;
	}
}