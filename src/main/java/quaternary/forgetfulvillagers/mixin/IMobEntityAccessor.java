package quaternary.forgetfulvillagers.mixin;

import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.LocalDifficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(MobEntity.class)
public interface IMobEntityAccessor {
	@Invoker("method_5984")
	void fv_callMethod5984(LocalDifficulty ld);
}
