package wdfeer.limited_trading.mixin;

import net.minecraft.entity.passive.VillagerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VillagerEntity.class)
public abstract class VillagerMixin {
    @Shadow
    private long lastRestockTime;

    @Shadow
    private int restocksToday;

    @Inject(method = "canRestock", at = @At("HEAD"), cancellable = true)
    void canRestock(CallbackInfoReturnable<Boolean> cir) {
        var world = ((VillagerEntity)(Object) this).getWorld();
        cir.setReturnValue(
                this.restocksToday == 0 || world.getTime() > this.lastRestockTime + 4800L
        );
    }
}
