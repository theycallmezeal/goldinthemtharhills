package us.thinkplank.goldinthemtharhills;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class ItemGoldPan extends Item {
	private static final double probability = 0.02;
	private static final double bonus = 0.05;
	
	public ItemGoldPan() {
		super();
        setMaxStackSize(64);
        setCreativeTab(GoldInThemTharHills.tabGITTH);
        setRegistryName("gold_pan");
	}
	
    @Override
    public EnumActionResult onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		Block block = world.getBlockState(pos.offset(facing)).getBlock();
		
		if (block.equals(Blocks.WATER) || block.equals(Blocks.FLOWING_WATER)) {
			double chance = probability;
			
			Biome biome = world.getBiomeForCoordsBody(pos);
			if (biome.equals(Biomes.EXTREME_HILLS)) {
				chance += bonus;
			}
			
			if (Math.random() < chance) {
				player.inventory.addItemStackToInventory(new ItemStack(Items.GOLD_NUGGET));
				if (!world.isRemote) {
					world.spawnEntityInWorld(new EntityXPOrb(world, pos.offset(facing).getX(), pos.offset(facing).getY(), pos.offset(facing).getZ(), 5));
				}
			}
		}
		return EnumActionResult.SUCCESS;
    }
}
