
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package fr.blocblocthebloc.bussounds.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import fr.blocblocthebloc.bussounds.BussoundsMod;

public class BussoundsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BussoundsMod.MODID);
	public static final RegistryObject<Item> PLACE_CAMPAGNE = block(BussoundsModBlocks.PLACE_CAMPAGNE, BussoundsModTabs.TAB_SOUNDS);
	public static final RegistryObject<Item> CHAMPS_DE_BLE = block(BussoundsModBlocks.CHAMPS_DE_BLE, BussoundsModTabs.TAB_SOUNDS);
	public static final RegistryObject<Item> SOGZIT = block(BussoundsModBlocks.SOGZIT, BussoundsModTabs.TAB_SOUNDS);
	public static final RegistryObject<Item> PAIN = block(BussoundsModBlocks.PAIN, BussoundsModTabs.TAB_SOUNDS);
	public static final RegistryObject<Item> FEB_21 = block(BussoundsModBlocks.FEB_21, BussoundsModTabs.TAB_SOUNDS);
	public static final RegistryObject<Item> PARC_COMMUN = block(BussoundsModBlocks.PARC_COMMUN, BussoundsModTabs.TAB_SOUNDS);
	public static final RegistryObject<Item> ROUST = block(BussoundsModBlocks.ROUST, BussoundsModTabs.TAB_SOUNDS);
	public static final RegistryObject<Item> POINT_BRONZE = block(BussoundsModBlocks.POINT_BRONZE, BussoundsModTabs.TAB_SOUNDS);
	public static final RegistryObject<Item> CENTRE_VILLE = block(BussoundsModBlocks.CENTRE_VILLE, BussoundsModTabs.TAB_SOUNDS);
	public static final RegistryObject<Item> GARE = block(BussoundsModBlocks.GARE, BussoundsModTabs.TAB_SOUNDS);
	public static final RegistryObject<Item> CASTADREAM = block(BussoundsModBlocks.CASTADREAM, BussoundsModTabs.TAB_SOUNDS);
	public static final RegistryObject<Item> FEB_29 = block(BussoundsModBlocks.FEB_29, BussoundsModTabs.TAB_SOUNDS);
	public static final RegistryObject<Item> LITIEUM = block(BussoundsModBlocks.LITIEUM, BussoundsModTabs.TAB_SOUNDS);
	public static final RegistryObject<Item> FRANK = block(BussoundsModBlocks.FRANK, BussoundsModTabs.TAB_SOUNDS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
