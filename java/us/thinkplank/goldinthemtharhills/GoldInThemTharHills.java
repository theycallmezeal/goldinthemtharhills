package us.thinkplank.goldinthemtharhills;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = GoldInThemTharHills.MODID, version = GoldInThemTharHills.VERSION)
public class GoldInThemTharHills {
    public static final String MODID = "goldinthemtharhills";
    public static final String VERSION = "1.0.2";
    
    public static final CreativeTabs tabGITTH = new CreativeTabs("gitth") {
    	@Override 
    	public ItemStack getTabIconItem() {
    		return new ItemStack(Item.getItemFromBlock(sluice));
    	}
    };
    
    public static final BlockSluice sluice = new BlockSluice("sluice", Material.WOOD, 16, 8);
    public static final BlockSluice iron_sluice = new BlockSluice("iron_sluice", Material.IRON, 80, 24);
    public static final ItemGoldPan gold_pan = new ItemGoldPan();
    
    @SidedProxy(clientSide = "us.thinkplank.goldinthemtharhills.ClientProxy", serverSide = "us.thinkplank.goldinthemtharhills.ServerProxy")
    public static CommonProxy proxy;
    
    @Mod.Instance
    public static GoldInThemTharHills instance;
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	sluice.addFluid(Blocks.FLOWING_WATER);
    	sluice.addFluid(Blocks.WATER);
    	
    	iron_sluice.addFluid(Blocks.FLOWING_WATER);
    	
    	proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
