package us.thinkplank.goldinthemtharhills;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;


public class BlockSluice extends Block {
	private static double probability;
	private static double bonus;
	private static Set<Block> fluids;
	
	public BlockSluice(String name, Material material, double nugsPerSec, double bonusPerSec) {
		super(Material.WOOD);
		setHardness(2F);
        setSoundType(SoundType.METAL);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.TOOLS);
        setHarvestLevel("axe", 0);
        setTickRandomly(true);
        
        this.probability = nugsPerSec / (60.0 * 60.0 * 20.0);
        this.bonus = bonus / (60.0 * 60.0 * 20.0);
        this.fluids = new LinkedHashSet<Block>();
	}
	
	public void addFluid(Block fluid) {
		this.fluids.add(fluid);
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
		IBlockState blockAbove = world.getBlockState(pos.up());
		Block blockType = blockAbove.getBlock();
		
		double chance = probability;
		
		Biome biome = world.getBiomeForCoordsBody(pos);
		if (biome.equals(Biomes.EXTREME_HILLS)) {
			chance += bonus;
		}
		
		if (this.fluids.isEmpty()) {
			fluids.add(Blocks.FLOWING_WATER);
			fluids.add(Blocks.WATER);
		}
		
		if (random.nextDouble() < chance && this.fluids.contains(blockType)) {
			double x = (double) pos.up().getX();
			double y = (double) pos.up().getY();
			double z = (double) pos.up().getZ();
			ItemStack stack = new ItemStack(Items.GOLD_NUGGET);
			EntityItem nugget = new EntityItem(world, x, y, z, stack);
			world.spawnEntityInWorld(nugget);
		}
	}
}
