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
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = GoldInThemTharHills.MODID, version = GoldInThemTharHills.VERSION)
public class GoldInThemTharHills {
    public static final String MODID = "goldinthemtharhills";
    public static final String VERSION = "1.0";
    
    public static final BlockSluice sluice = new BlockSluice("sluice", Material.WOOD, 0.05, 0.02);
    public static final BlockSluice iron_sluice = new BlockSluice("iron_sluice", Material.IRON, 0.15, 0.07);
    public static final ItemGoldPan gold_pan = new ItemGoldPan();
    
    @SidedProxy(clientSide = "us.thinkplank.goldinthemtharhills.ClientProxy", serverSide = "us.thinkplank.goldinthemtharhills.ServerProxy")
    public static CommonProxy proxy;
    
    @Mod.Instance
    public static GoldInThemTharHills instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	sluice.addFluid(Blocks.FLOWING_WATER);
    	sluice.addFluid(Blocks.WATER);
    	
    	iron_sluice.addFluid(Blocks.FLOWING_WATER);
    	
    	proxy.preInit(event);
    }
}
