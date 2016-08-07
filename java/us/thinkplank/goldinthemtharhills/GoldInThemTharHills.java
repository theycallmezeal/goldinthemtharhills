package us.thinkplank.goldinthemtharhills;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = GoldInThemTharHills.MODID, version = GoldInThemTharHills.VERSION)
public class GoldInThemTharHills {
    public static final String MODID = "goldinthemtharhills";
    public static final String VERSION = "1.0";
    
    public static final BlockSluice sluice = new BlockSluice("sluice", Material.WOOD, 0.05, 0.02);
    public static final BlockSluice iron_sluice = new BlockSluice("iron_sluice", Material.IRON, 0.10, 0.05);
    public static final ItemGoldPan gold_pan = new ItemGoldPan();
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	sluice.addFluid(Blocks.FLOWING_WATER);
    	sluice.addFluid(Blocks.WATER);
    	
    	iron_sluice.addFluid(Blocks.FLOWING_WATER);
    	
    	registerItem(gold_pan);
    	registerBlock(sluice);
    	registerBlock(iron_sluice);
    	
    	GameRegistry.addRecipe(new ItemStack(gold_pan), "x x", " y ", 'x', Items.IRON_INGOT, 'y', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
    	GameRegistry.addRecipe(new ItemStack(sluice), "x x", "xyx", "xxx", 'x', Blocks.PLANKS, 'y', gold_pan);
    	GameRegistry.addRecipe(new ItemStack(iron_sluice), "x x", "xyx", "xxx", 'x', Items.IRON_INGOT, 'y', gold_pan);
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
    }
    
    private static void registerBlock(Block block) {
    	block.setUnlocalizedName(block.getRegistryName().getResourcePath());
    	GameRegistry.register(block);
    	GameRegistry.register(new ItemBlock(block), block.getRegistryName());
    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
    
    private static void registerItem(Item item) {
    	item.setUnlocalizedName(item.getRegistryName().getResourcePath());
    	GameRegistry.register(item);
    	ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
