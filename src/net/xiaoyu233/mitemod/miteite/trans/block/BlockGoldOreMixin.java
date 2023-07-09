//package net.xiaoyu233.mitemod.miteite.trans.block;
//
//import net.minecraft.*;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Overwrite;
//import org.spongepowered.asm.mixin.Shadow;
//
//@Mixin(BlockGoldOre.class)
//public class BlockGoldOreMixin extends BlockOre implements IBlockWithSubtypes {
//
//    public BlockGoldOreMixin(int par1, Material vein_material, int min_harvest_level) {
//        super(par1, vein_material, min_harvest_level);
//    }
//    @Overwrite
//    public int getMetadataForPlacement(World world, int x, int y, int z, ItemStack item_stack, Entity entity, EnumFace face, float offset_x, float offset_y, float offset_z) {
//        return item_stack.getItemSubtype() | 1;
//    }
//
//    @Shadow
//    public String[] getTextures() {
//        return new String[0];
//    }
//
//    @Shadow
//    public String[] getNames() {
//        return new String[0];
//    }
//}
