package us.thinkplank.goldinthemtharhills;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy {
	@SubscribeEvent
	public static void registerThings(ModelRegistryEvent event) {
    	registerItemModel(GoldInThemTharHills.gold_pan);
    	registerBlockModel(GoldInThemTharHills.sluice);
    	registerBlockModel(GoldInThemTharHills.iron_sluice);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerBlockModel(Block block) {
		ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, model);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerItemModel(Item item) {
		ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(item, 0, model);
	}
}