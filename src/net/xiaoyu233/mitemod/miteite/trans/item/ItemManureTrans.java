//package net.xiaoyu233.mitemod.miteite.trans.item;
//
//import net.minecraft.*;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//
//import java.util.List;
//
//@Mixin(ItemManure.class)
//public class ItemManureTrans extends Item {
//   public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
//      RaycastCollision rc = player.getSelectedObject(partial_tick, false);
//      if (rc != null && rc.isBlock()) {
//         if (this.tryFertilizeBlock(rc.world, rc.block_hit_x, rc.block_hit_y, rc.block_hit_z, rc.face_hit, player.getHeldItemStack(), player)) {
//            if (player.onClient()) {
//               player.swingArm();
//            } else if (!player.inCreativeMode()) {
//               player.convertOneOfHeldItem(null);
//            }
//
//            return true;
//         } else {
//            World world = rc.world;
//            int x = rc.block_hit_x;
//            int y = rc.block_hit_y;
//            int z = rc.block_hit_z;
//            ItemStack item_stack = player.getHeldItemStack();
//            if (!ItemDye.tryFertilize(item_stack, world, x, y, z, rc.face_hit)) {
//               return false;
//            } else {
//               if (player.onServer() && !player.inCreativeMode()) {
//                  player.convertOneOfHeldItem(null);
//               }
//
//               if (ItemDye.suppress_standard_particle_effect) {
//                  ItemDye.suppress_standard_particle_effect = false;
//                  return true;
//               } else {
//                  if (player.onServer()) {
//                     Block block = rc.getBlockHit();
//                     if (block == Block.grass || block == Block.tilledField || block == Block.mycelium) {
//                        ++y;
//                     }
//
//                     world.playAuxSFX(2005, x, y, z, 0);
//                  }
//
//                  if (world.getBlock(x, y, z) instanceof BlockCrops) {
//                     player.triggerAchievement(AchievementList.plantDoctor);
//                  }
//
//                  return true;
//               }
//            }
//         }
//      } else {
//         //System.out.println("okokok");
//         return false;
//      }
//   }
//
//   public int getMaxItemUseDuration(ItemStack par1ItemStack) {
//      return 32;
//   }
//
//   public boolean isEatable(int item_subtype) {
//      return true;
//   }
//
//
//   public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
//      if (extended_info) {
//         info.add(EnumChatFormat.UNDERLINE + Translator.getFormatted("item.babatip.oooop"));
//      }
//   }
//
//   public void onItemUseFinish(ItemStack item_stack, World world, EntityPlayer player) {
//      if (player.onServer()) {
//         int id = player.getRand().nextInt(23);
//         System.out.println("addEffectID: " + id);
//         if(id != 0){
//            player.addPotionEffect(new MobEffect(id, 100, 1));
//         } else {
//            player.addPotionEffect(new MobEffect(MobEffectList.wither.id, 100, 1));
//         }
//
//         world.playSoundAtEntity(player, "random.burp", 0.5F, player.getRand().nextFloat() * 0.1F + 0.9F);
//      }
//
//      super.onItemUseFinish(item_stack, world, player);
//   }
//
//   @Shadow
//   private boolean tryFertilizeBlock(World world, int block_hit_x, int block_hit_y, int block_hit_z, EnumFace face_hit, ItemStack heldItemStack, EntityPlayer player) {
//      return false;
//   }
//}
