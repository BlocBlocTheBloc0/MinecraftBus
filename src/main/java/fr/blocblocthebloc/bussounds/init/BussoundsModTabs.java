
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package fr.blocblocthebloc.bussounds.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class BussoundsModTabs {
	public static CreativeModeTab TAB_SOUNDS;

	public static void load() {
		TAB_SOUNDS = new CreativeModeTab("tabsounds") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(BussoundsModBlocks.PLACE_CAMPAGNE.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
