package quaternary.forgetfulvillagers.mixin;

import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.LocalDifficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ZombieEntity.class)
public interface IZombieEntityAccessor {
	@Invoker("initEquipment")
	void fv_callInitEquipment(LocalDifficulty ld);
}
