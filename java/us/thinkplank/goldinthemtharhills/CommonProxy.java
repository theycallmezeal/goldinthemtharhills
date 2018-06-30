package us.thinkplank.goldinthemtharhills;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(GoldInThemTharHills.sluice);
        event.getRegistry().register(GoldInThemTharHills.iron_sluice);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(GoldInThemTharHills.gold_pan);
    	registerItemBlock(GoldInThemTharHills.sluice, event);
    	registerItemBlock(GoldInThemTharHills.iron_sluice, event);
    }
    
    private static void registerItemBlock(Block block, RegistryEvent.Register<Item> event) {
    	Item itemBlock = new ItemBlock(block).setRegistryName(block.getRegistryName());
    	event.getRegistry().register(itemBlock);
    }

	public void preInit(FMLPreInitializationEvent event) {
		
	}
	
	public void init(FMLInitializationEvent event) {
		
	}
	
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
