package us.thinkplank.goldinthemtharhills;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GoldITTHEventHandler {
	private static final double probability = 0.02;
	private static final double bonus = 0.05;
	
	@SubscribeEvent
	public void onPlayerRightClick(RightClickBlock event) {
		World worldIn = event.getWorld();
		BlockPos pos = event.getPos();
		IBlockState state = worldIn.getBlockState(pos);
		EntityPlayer player = event.getEntityPlayer();
		
		Block targetBlock = worldIn.getBlockState(pos).getBlock();
		Item heldItem = player.inventory.getCurrentItem().getItem();
		
		if (targetBlock.equals(Blocks.WATER) || targetBlock.equals(Blocks.FLOWING_WATER)) {
			if (heldItem.equals(GoldInThemTharHills.gold_pan)) {
				
				double chance = probability;
				
				Biome biome = worldIn.getBiomeForCoordsBody(pos);
				if (biome.equals(Biomes.EXTREME_HILLS)) {
					chance += bonus;
				}
				
				if (true) {
					double x = (double) pos.getX();
					double y = (double) pos.getY();
					double z = (double) pos.getZ();
					ItemStack stack = new ItemStack(Items.GOLD_NUGGET);
					EntityItem nugget = new EntityItem(worldIn, x, y, z, stack);
					worldIn.spawnEntityInWorld(nugget);
				}
			}
		}
	}
}
