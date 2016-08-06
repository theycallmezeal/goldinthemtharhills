package us.thinkplank.goldinthemtharhills;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = GoldInThemTharHills.MODID, version = GoldInThemTharHills.VERSION)
public class GoldInThemTharHills {
    public static final String MODID = "goldinthemtharhills";
    public static final String VERSION = "1.0";
    
    public static final BlockSluice sluice = new BlockSluice();
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	registerBlock(sluice);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    }
    
    private static void registerBlock(Block block) {
    	block.setUnlocalizedName(block.getRegistryName().getResourcePath());
    	GameRegistry.register(block);
    	GameRegistry.register(new ItemBlock(block), block.getRegistryName());
    	ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
}
