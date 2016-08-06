package us.thinkplank.goldinthemtharhills;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSluice extends Block {
	public BlockSluice() {
		super(Material.WOOD);
		setHardness(2F);
        setSoundType(SoundType.WOOD);
        setRegistryName("sluice");
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHarvestLevel("axe", 0);
	}
}
