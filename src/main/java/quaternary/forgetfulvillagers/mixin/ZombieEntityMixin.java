package quaternary.forgetfulvillagers.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import quaternary.forgetfulvillagers.DummyEntityData;

@Mixin(ZombieEntity.class)
public abstract class ZombieEntityMixin extends HostileEntity {
	public ZombieEntityMixin(EntityType<?> entityType_1, World world_1) {
		super(entityType_1, world_1);
	}
	
	/**
	 * Hi I'm a javadoc to shut up the minecraftdev plugin.
	 * This excavates the villager zombie logic and replaces it with my own.
	 * @author quaternary
	 */
	@Overwrite
	public void method_5874(LivingEntity ent) {
		if(ent instanceof VillagerEntity) {
			ZombieEntity thus = (ZombieEntity) (Object) this; 
			
			VillagerEntity villager = (VillagerEntity) ent; 
			ZombieVillagerEntity zomble = new ZombieVillagerEntity(world);
			zomble.setPositionAndAngles(villager);
			world.method_8463(villager); //some sorta invalidation method...?
			
			//!! Hack alert !!
			//There's this class that implements EntityData, "ZombieEntity.class_1644".
			//It's a piece of shit with a private constructor HUGE pain in the ass to instantiate
			//I mean fr half the mod source was just reflecting that dumbfuck constructor
			//And it's pretty much just a wrapper around whether it should be a baby zomble or not anyways
			//Boooo.
			//Passing null into this function could make the villager spawn as a baby since
			//the zombie override of this function randomly chooses a baby or not. :|
			//But calling it on a new EntityData works, with no adverse side effects!
			zomble.prepareEntityData(world, world.getLocalDifficulty(new BlockPos(zomble)), SpawnType.CONVERSION, new DummyEntityData(), null);
			
			//Caveat: this stuff is behind an instanceof check in the above func. Let's just
			//do it manually
			LocalDifficulty ld = world.getLocalDifficulty(new BlockPos(thus));
			zomble.setBreakDoors(method_7212() && this.random.nextFloat() < ld.method_5458() * 0.1F);
			((IZombieEntityAccessor)zomble).fv_callInitEquipment(ld);
			((IMobEntityAccessor)zomble).fv_callMethod5984(ld);
			
			//copy some of the villager data to the zombie villager too
			zomble.setVillagerData(villager.getVillagerData());
			zomble.setChild(villager.isChild());
			zomble.setAiDisabled(villager.isAiDisabled());
			if(villager.hasCustomName()) {
				zomble.setCustomName(villager.getCustomName());
				zomble.setCustomNameVisible(villager.isCustomNameVisible());
			}
			
			//*maybe* copy the trades to the zombie villager - only maybe!
			Difficulty d = world.getDifficulty();
			boolean shouldRememberTrades;
			
			if(d == Difficulty.EASY) shouldRememberTrades = true;
			else if(d == Difficulty.NORMAL) shouldRememberTrades = world.random.nextBoolean();
			else shouldRememberTrades = false;
			
			if(shouldRememberTrades) {
				zomble.setOfferData(villager.getRecipes().deserialize());
			}
			
			//make the zombie villager not despawn...!
			zomble.setPersistent();
			
			//Ok this is epic all done
			world.spawnEntity(zomble);
			world.fireWorldEvent(null, 1026, new BlockPos(thus), 0);
		}
	}
	
	@Shadow protected abstract boolean method_7212();
}
