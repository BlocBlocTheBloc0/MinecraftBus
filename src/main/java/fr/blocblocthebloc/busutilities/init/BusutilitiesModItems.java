
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package fr.blocblocthebloc.busutilities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import fr.blocblocthebloc.busutilities.item.Ticket3VoyageItem;
import fr.blocblocthebloc.busutilities.item.Ticket3Voyage2Item;
import fr.blocblocthebloc.busutilities.item.Ticket3Voyage1Item;
import fr.blocblocthebloc.busutilities.item.Ticket3Voyage0Item;
import fr.blocblocthebloc.busutilities.item.Ticket1VoyageItem;
import fr.blocblocthebloc.busutilities.item.Ticket1Vaoyage0Item;
import fr.blocblocthebloc.busutilities.item.Ticket10VoyageItem;
import fr.blocblocthebloc.busutilities.item.Ticket10Voyage9Item;
import fr.blocblocthebloc.busutilities.item.Ticket10Voyage8Item;
import fr.blocblocthebloc.busutilities.item.Ticket10Voyage7Item;
import fr.blocblocthebloc.busutilities.item.Ticket10Voyage6Item;
import fr.blocblocthebloc.busutilities.item.Ticket10Voyage5Item;
import fr.blocblocthebloc.busutilities.item.Ticket10Voyage4Item;
import fr.blocblocthebloc.busutilities.item.Ticket10Voyage3Item;
import fr.blocblocthebloc.busutilities.item.Ticket10Voyage2Item;
import fr.blocblocthebloc.busutilities.item.Ticket10Voyage1Item;
import fr.blocblocthebloc.busutilities.item.Ticket10Voyage0Item;
import fr.blocblocthebloc.busutilities.item.CartedetransportItem;
import fr.blocblocthebloc.busutilities.item.CartedetransportIllimiteItem;
import fr.blocblocthebloc.busutilities.item.Cartedetransport9Item;
import fr.blocblocthebloc.busutilities.item.Cartedetransport8Item;
import fr.blocblocthebloc.busutilities.item.Cartedetransport7Item;
import fr.blocblocthebloc.busutilities.item.Cartedetransport6Item;
import fr.blocblocthebloc.busutilities.item.Cartedetransport5Item;
import fr.blocblocthebloc.busutilities.item.Cartedetransport4Item;
import fr.blocblocthebloc.busutilities.item.Cartedetransport3Item;
import fr.blocblocthebloc.busutilities.item.Cartedetransport2Item;
import fr.blocblocthebloc.busutilities.item.Cartedetransport1Item;
import fr.blocblocthebloc.busutilities.item.Cartedetransport10Item;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

public class BusutilitiesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BusutilitiesMod.MODID);
	public static final RegistryObject<Item> VERIF_BLOC = block(BusutilitiesModBlocks.VERIF_BLOC, BusutilitiesModTabs.TAB_CREATIFTAB);
	public static final RegistryObject<Item> SHOP_BLOC = block(BusutilitiesModBlocks.SHOP_BLOC, BusutilitiesModTabs.TAB_CREATIFTAB);
	public static final RegistryObject<Item> TICKET_1_VAOYAGE_0 = REGISTRY.register("ticket_1_vaoyage_0", () -> new Ticket1Vaoyage0Item());
	public static final RegistryObject<Item> TICKET_1_VOYAGE = REGISTRY.register("ticket_1_voyage", () -> new Ticket1VoyageItem());
	public static final RegistryObject<Item> TICKET_3_VOYAGE = REGISTRY.register("ticket_3_voyage", () -> new Ticket3VoyageItem());
	public static final RegistryObject<Item> TICKET_3_VOYAGE_0 = REGISTRY.register("ticket_3_voyage_0", () -> new Ticket3Voyage0Item());
	public static final RegistryObject<Item> TICKET_10_VOYAGE = REGISTRY.register("ticket_10_voyage", () -> new Ticket10VoyageItem());
	public static final RegistryObject<Item> TICKET_10_VOYAGE_0 = REGISTRY.register("ticket_10_voyage_0", () -> new Ticket10Voyage0Item());
	public static final RegistryObject<Item> CARTEDETRANSPORT = REGISTRY.register("cartedetransport", () -> new CartedetransportItem());
	public static final RegistryObject<Item> CARTEDETRANSPORT_10 = REGISTRY.register("cartedetransport_10", () -> new Cartedetransport10Item());
	public static final RegistryObject<Item> CARTEDETRANSPORT_5 = REGISTRY.register("cartedetransport_5", () -> new Cartedetransport5Item());
	public static final RegistryObject<Item> CARTEDETRANSPORT_ILLIMITE = REGISTRY.register("cartedetransport_illimite",
			() -> new CartedetransportIllimiteItem());
	public static final RegistryObject<Item> TICKET_3_VOYAGE_2 = REGISTRY.register("ticket_3_voyage_2", () -> new Ticket3Voyage2Item());
	public static final RegistryObject<Item> TICKET_3_VOYAGE_1 = REGISTRY.register("ticket_3_voyage_1", () -> new Ticket3Voyage1Item());
	public static final RegistryObject<Item> TICKET_10_VOYAGE_9 = REGISTRY.register("ticket_10_voyage_9", () -> new Ticket10Voyage9Item());
	public static final RegistryObject<Item> TICKET_10_VOYAGE_8 = REGISTRY.register("ticket_10_voyage_8", () -> new Ticket10Voyage8Item());
	public static final RegistryObject<Item> TICKET_10_VOYAGE_7 = REGISTRY.register("ticket_10_voyage_7", () -> new Ticket10Voyage7Item());
	public static final RegistryObject<Item> TICKET_10_VOYAGE_6 = REGISTRY.register("ticket_10_voyage_6", () -> new Ticket10Voyage6Item());
	public static final RegistryObject<Item> TICKET_10_VOYAGE_5 = REGISTRY.register("ticket_10_voyage_5", () -> new Ticket10Voyage5Item());
	public static final RegistryObject<Item> TICKET_10_VOYAGE_4 = REGISTRY.register("ticket_10_voyage_4", () -> new Ticket10Voyage4Item());
	public static final RegistryObject<Item> TICKET_10_VOYAGE_3 = REGISTRY.register("ticket_10_voyage_3", () -> new Ticket10Voyage3Item());
	public static final RegistryObject<Item> TICKET_10_VOYAGE_2 = REGISTRY.register("ticket_10_voyage_2", () -> new Ticket10Voyage2Item());
	public static final RegistryObject<Item> TICKET_10_VOYAGE_1 = REGISTRY.register("ticket_10_voyage_1", () -> new Ticket10Voyage1Item());
	public static final RegistryObject<Item> CARTEDETRANSPORT_9 = REGISTRY.register("cartedetransport_9", () -> new Cartedetransport9Item());
	public static final RegistryObject<Item> CARTEDETRANSPORT_8 = REGISTRY.register("cartedetransport_8", () -> new Cartedetransport8Item());
	public static final RegistryObject<Item> CARTEDETRANSPORT_7 = REGISTRY.register("cartedetransport_7", () -> new Cartedetransport7Item());
	public static final RegistryObject<Item> CARTEDETRANSPORT_6 = REGISTRY.register("cartedetransport_6", () -> new Cartedetransport6Item());
	public static final RegistryObject<Item> CARTEDETRANSPORT_4 = REGISTRY.register("cartedetransport_4", () -> new Cartedetransport4Item());
	public static final RegistryObject<Item> CARTEDETRANSPORT_3 = REGISTRY.register("cartedetransport_3", () -> new Cartedetransport3Item());
	public static final RegistryObject<Item> CARTEDETRANSPORT_2 = REGISTRY.register("cartedetransport_2", () -> new Cartedetransport2Item());
	public static final RegistryObject<Item> CARTEDETRANSPORT_1 = REGISTRY.register("cartedetransport_1", () -> new Cartedetransport1Item());
	public static final RegistryObject<Item> LIGNE_A = block(BusutilitiesModBlocks.LIGNE_A, BusutilitiesModTabs.TAB_CREATIFTAB);
	public static final RegistryObject<Item> LIGNE_B = block(BusutilitiesModBlocks.LIGNE_B, BusutilitiesModTabs.TAB_CREATIFTAB);
	public static final RegistryObject<Item> LIGNE_C = block(BusutilitiesModBlocks.LIGNE_C, BusutilitiesModTabs.TAB_CREATIFTAB);
	public static final RegistryObject<Item> LIGNE_D = block(BusutilitiesModBlocks.LIGNE_D, BusutilitiesModTabs.TAB_CREATIFTAB);
	public static final RegistryObject<Item> LIGNE_E = block(BusutilitiesModBlocks.LIGNE_E, BusutilitiesModTabs.TAB_CREATIFTAB);
	public static final RegistryObject<Item> LIGNE_F = block(BusutilitiesModBlocks.LIGNE_F, BusutilitiesModTabs.TAB_CREATIFTAB);
	public static final RegistryObject<Item> LIGNE_G = block(BusutilitiesModBlocks.LIGNE_G, BusutilitiesModTabs.TAB_CREATIFTAB);
	public static final RegistryObject<Item> LIGNE_H = block(BusutilitiesModBlocks.LIGNE_H, BusutilitiesModTabs.TAB_CREATIFTAB);
	public static final RegistryObject<Item> LIGNE_EA = block(BusutilitiesModBlocks.LIGNE_EA, BusutilitiesModTabs.TAB_CREATIFTAB);
	public static final RegistryObject<Item> LIGNE_EB = block(BusutilitiesModBlocks.LIGNE_EB, BusutilitiesModTabs.TAB_CREATIFTAB);
	public static final RegistryObject<Item> LIGNE_EC = block(BusutilitiesModBlocks.LIGNE_EC, BusutilitiesModTabs.TAB_CREATIFTAB);
	public static final RegistryObject<Item> LIGNE_ED = block(BusutilitiesModBlocks.LIGNE_ED, BusutilitiesModTabs.TAB_CREATIFTAB);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
