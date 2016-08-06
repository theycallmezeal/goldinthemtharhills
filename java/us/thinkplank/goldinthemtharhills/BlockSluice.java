package us.thinkplank.goldinthemtharhills;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class BlockSluice extends Block {
	public BlockSluice() {
		super(Material.WOOD);
		setHardness(2F);
        setSoundType(SoundType.WOOD);
        setRegistryName("sluice");
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHarvestLevel("axe", 0);
        setTickRandomly(true);
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
		IBlockState blockAbove = world.getBlockState(pos.up());
		Block blockType = blockAbove.getBlock();
		
		if (blockType.equals(Blocks.FLOWING_WATER)) {
			double x = (double) pos.up().getX();
			double y = (double) pos.up().getY();
			double z = (double) pos.up().getZ();
			ItemStack stack = new ItemStack(Items.GOLD_NUGGET);
			EntityItem nugget = new EntityItem(world, x, y, z, stack);
			world.spawnEntityInWorld(nugget);
		}
	}
}
