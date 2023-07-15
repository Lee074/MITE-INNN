package net.xiaoyu233.mitemod.miteite.trans.entity.ai;


import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PathfinderGoalMakeLove.class)
public class PathfinderGoalMakeLoveMixin extends PathfinderGoal {

    @Overwrite
    private void giveBirth() {
        EntityVillager var1 = this.villagerObj.func_90012_b(this.mate);
        this.mate.setGrowingAgeAfterBreeding();
        this.villagerObj.setGrowingAgeAfterBreeding();
        var1.setGrowingAgeToNewborn();
        var1.setLocationAndAngles(this.villagerObj.posX, this.villagerObj.posY, this.villagerObj.posZ, 0.0F, 0.0F);
        this.worldObj.spawnEntityInWorld(var1);
        this.worldObj.setEntityState(var1, EnumEntityState.villager_mated);
        if(this.villagerObj.getRand().nextInt(2) == 0){
            var1.dropItemStack(new ItemStack(Items.voucherVillager));
        }

    }

//    public void test(int var, int var2, int var3){
//        Entity var4 = this.worldObj.findNearestEntityWithinAABB(EntityVillager.class, this.villagerObj.boundingBox.expand(8.0, 3.0, 8.0), this.villagerObj);
//        this.mate = (EntityVillager)var4;
//
//        EntityVillager var1 = this.villagerObj.func_90012_b(this.mate);
//        this.mate.setGrowingAgeAfterBreeding();
//        this.villagerObj.setGrowingAgeAfterBreeding();
//        var1.setGrowingAgeToNewborn();
//        var1.setLocationAndAngles(var, var2, var3, 0.0F, 0.0F);
//        this.villagerObj.dropItemStack(new ItemStack(Items.voucherVillager));
//        this.worldObj.spawnEntityInWorld(var1);
//        this.worldObj.setEntityState(var1, EnumEntityState.villager_mated);
//    }

    @Shadow
    private EntityVillager villagerObj;
    @Shadow
    private EntityVillager mate;
    @Shadow
    private World worldObj;

    @Shadow
    public boolean shouldExecute() {
        return false;
    }
}
