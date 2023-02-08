
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package fr.blocblocthebloc.bussounds.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import fr.blocblocthebloc.bussounds.block.SogzitBlock;
import fr.blocblocthebloc.bussounds.block.RoustBlock;
import fr.blocblocthebloc.bussounds.block.PointBronzeBlock;
import fr.blocblocthebloc.bussounds.block.PlaceCampagneBlock;
import fr.blocblocthebloc.bussounds.block.ParcCommunBlock;
import fr.blocblocthebloc.bussounds.block.PainBlock;
import fr.blocblocthebloc.bussounds.block.LitieumBlock;
import fr.blocblocthebloc.bussounds.block.GareBlock;
import fr.blocblocthebloc.bussounds.block.FrankBlock;
import fr.blocblocthebloc.bussounds.block.Feb29Block;
import fr.blocblocthebloc.bussounds.block.Feb21Block;
import fr.blocblocthebloc.bussounds.block.ChampsDeBleBlock;
import fr.blocblocthebloc.bussounds.block.CentreVilleBlock;
import fr.blocblocthebloc.bussounds.block.CastadreamBlock;
import fr.blocblocthebloc.bussounds.BussoundsMod;

public class BussoundsModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, BussoundsMod.MODID);
	public static final RegistryObject<Block> PLACE_CAMPAGNE = REGISTRY.register("place_campagne", () -> new PlaceCampagneBlock());
	public static final RegistryObject<Block> CHAMPS_DE_BLE = REGISTRY.register("champs_de_ble", () -> new ChampsDeBleBlock());
	public static final RegistryObject<Block> SOGZIT = REGISTRY.register("sogzit", () -> new SogzitBlock());
	public static final RegistryObject<Block> PAIN = REGISTRY.register("pain", () -> new PainBlock());
	public static final RegistryObject<Block> FEB_21 = REGISTRY.register("feb_21", () -> new Feb21Block());
	public static final RegistryObject<Block> PARC_COMMUN = REGISTRY.register("parc_commun", () -> new ParcCommunBlock());
	public static final RegistryObject<Block> ROUST = REGISTRY.register("roust", () -> new RoustBlock());
	public static final RegistryObject<Block> POINT_BRONZE = REGISTRY.register("point_bronze", () -> new PointBronzeBlock());
	public static final RegistryObject<Block> CENTRE_VILLE = REGISTRY.register("centre_ville", () -> new CentreVilleBlock());
	public static final RegistryObject<Block> GARE = REGISTRY.register("gare", () -> new GareBlock());
	public static final RegistryObject<Block> CASTADREAM = REGISTRY.register("castadream", () -> new CastadreamBlock());
	public static final RegistryObject<Block> FEB_29 = REGISTRY.register("feb_29", () -> new Feb29Block());
	public static final RegistryObject<Block> LITIEUM = REGISTRY.register("litieum", () -> new LitieumBlock());
	public static final RegistryObject<Block> FRANK = REGISTRY.register("frank", () -> new FrankBlock());
}
