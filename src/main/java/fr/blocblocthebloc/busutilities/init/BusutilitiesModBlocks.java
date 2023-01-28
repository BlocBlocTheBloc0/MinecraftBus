
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package fr.blocblocthebloc.busutilities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import fr.blocblocthebloc.busutilities.block.VerifBlocBlock;
import fr.blocblocthebloc.busutilities.block.ShopBlocBlock;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

public class BusutilitiesModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, BusutilitiesMod.MODID);
	public static final RegistryObject<Block> VERIF_BLOC = REGISTRY.register("verif_bloc", () -> new VerifBlocBlock());
	public static final RegistryObject<Block> SHOP_BLOC = REGISTRY.register("shop_bloc", () -> new ShopBlocBlock());
}
