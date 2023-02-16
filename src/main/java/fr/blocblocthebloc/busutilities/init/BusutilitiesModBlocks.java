
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package fr.blocblocthebloc.busutilities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import fr.blocblocthebloc.busutilities.block.VerifBlocBlock;
import fr.blocblocthebloc.busutilities.block.TermsBlocsBlock;
import fr.blocblocthebloc.busutilities.block.ShopBlocBlock;
import fr.blocblocthebloc.busutilities.block.LigneHBlock;
import fr.blocblocthebloc.busutilities.block.LigneGBlock;
import fr.blocblocthebloc.busutilities.block.LigneFBlock;
import fr.blocblocthebloc.busutilities.block.LigneEDBlock;
import fr.blocblocthebloc.busutilities.block.LigneECBlock;
import fr.blocblocthebloc.busutilities.block.LigneEBlock;
import fr.blocblocthebloc.busutilities.block.LigneEBBlock;
import fr.blocblocthebloc.busutilities.block.LigneEABlock;
import fr.blocblocthebloc.busutilities.block.LigneDBlock;
import fr.blocblocthebloc.busutilities.block.LigneCBlock;
import fr.blocblocthebloc.busutilities.block.LigneBBlock;
import fr.blocblocthebloc.busutilities.block.LigneABlock;
import fr.blocblocthebloc.busutilities.block.CalculesBlocsBlock;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

public class BusutilitiesModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, BusutilitiesMod.MODID);
	public static final RegistryObject<Block> VERIF_BLOC = REGISTRY.register("verif_bloc", () -> new VerifBlocBlock());
	public static final RegistryObject<Block> SHOP_BLOC = REGISTRY.register("shop_bloc", () -> new ShopBlocBlock());
	public static final RegistryObject<Block> LIGNE_A = REGISTRY.register("ligne_a", () -> new LigneABlock());
	public static final RegistryObject<Block> LIGNE_B = REGISTRY.register("ligne_b", () -> new LigneBBlock());
	public static final RegistryObject<Block> LIGNE_C = REGISTRY.register("ligne_c", () -> new LigneCBlock());
	public static final RegistryObject<Block> LIGNE_D = REGISTRY.register("ligne_d", () -> new LigneDBlock());
	public static final RegistryObject<Block> LIGNE_E = REGISTRY.register("ligne_e", () -> new LigneEBlock());
	public static final RegistryObject<Block> LIGNE_F = REGISTRY.register("ligne_f", () -> new LigneFBlock());
	public static final RegistryObject<Block> LIGNE_G = REGISTRY.register("ligne_g", () -> new LigneGBlock());
	public static final RegistryObject<Block> LIGNE_H = REGISTRY.register("ligne_h", () -> new LigneHBlock());
	public static final RegistryObject<Block> LIGNE_EA = REGISTRY.register("ligne_ea", () -> new LigneEABlock());
	public static final RegistryObject<Block> LIGNE_EB = REGISTRY.register("ligne_eb", () -> new LigneEBBlock());
	public static final RegistryObject<Block> LIGNE_EC = REGISTRY.register("ligne_ec", () -> new LigneECBlock());
	public static final RegistryObject<Block> LIGNE_ED = REGISTRY.register("ligne_ed", () -> new LigneEDBlock());
	public static final RegistryObject<Block> CALCULES_BLOCS = REGISTRY.register("calcules_blocs", () -> new CalculesBlocsBlock());
	public static final RegistryObject<Block> TERMS_BLOCS = REGISTRY.register("terms_blocs", () -> new TermsBlocsBlock());
}
