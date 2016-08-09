package us.thinkplank.goldinthemtharhills;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
    	registerItem(GoldInThemTharHills.gold_pan);
    	registerBlock(GoldInThemTharHills.sluice);
    	registerBlock(GoldInThemTharHills.iron_sluice);
    	
    	GameRegistry.addRecipe(new ItemStack(GoldInThemTharHills.gold_pan), "x x", " y ", 'x', Items.IRON_INGOT, 'y', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    	GameRegistry.addRecipe(new ItemStack(GoldInThemTharHills.sluice), "x x", "xyx", "xxx", 'x', Blocks.PLANKS, 'y', GoldInThemTharHills.gold_pan);
    	GameRegistry.addRecipe(new ItemStack(GoldInThemTharHills.iron_sluice), "x x", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', GoldInThemTharHills.gold_pan);
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
    
    public static void registerBlock(Block block) {
    	block.setUnlocalizedName(block.getRegistryName().getResourcePath());
    	GameRegistry.register(block);
    	GameRegistry.register(new ItemBlock(block), block.getRegistryName());
    }
    
    public static void registerItem(Item item) {
    	item.setUnlocalizedName(item.getRegistryName().getResourcePath());
    	GameRegistry.register(item);
    }
}
