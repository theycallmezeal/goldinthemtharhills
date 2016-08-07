package us.thinkplank.goldinthemtharhills;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
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
        setCreativeTab(CreativeTabs.TOOLS);
        setRegistryName("gold_pan");
	}
	
    @Override
    public EnumActionResult onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	if (itemStack == null) {
    		return EnumActionResult.FAIL;
    	} else {
			Block block = world.getBlockState(wheresTheWater(pos, facing)).getBlock();
			
			System.out.println("THE BLOCK IS " + block.toString());
			if (block.equals(Blocks.WATER)|| block.equals(Blocks.FLOWING_WATER)) {
				double chance = probability;
				
				Biome biome = world.getBiomeForCoordsBody(pos);
				if (biome.equals(Biomes.EXTREME_HILLS)) {
					chance += bonus;
				}
				
				if (true) {
					player.inventory.addItemStackToInventory(new ItemStack(Items.GOLD_NUGGET));
					if (!world.isRemote) {
						System.out.println("spawning now...");
						world.spawnEntityInWorld(new EntityXPOrb(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), 5));
						System.out.println("done spawning.");
					}
				}
			}
    		return EnumActionResult.SUCCESS;
    	}
    }
    
    private static BlockPos wheresTheWater(BlockPos blockPos, EnumFacing facing) {
    	if (facing == EnumFacing.UP)
    		return blockPos.up();
    	if (facing == EnumFacing.DOWN)
    		return blockPos.down();
    	if (facing == EnumFacing.NORTH)
    		return blockPos.north();
    	if (facing == EnumFacing.SOUTH)
    		return blockPos.south();
    	if (facing == EnumFacing.WEST)
    		return blockPos.west();
    	if (facing == EnumFacing.EAST)
    		return blockPos.east();
    	
    	return blockPos.up();
    }
}
