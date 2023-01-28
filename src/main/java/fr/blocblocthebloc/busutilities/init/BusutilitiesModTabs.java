
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package fr.blocblocthebloc.busutilities.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class BusutilitiesModTabs {
	public static CreativeModeTab TAB_CREATIFTAB;

	public static void load() {
		TAB_CREATIFTAB = new CreativeModeTab("tabcreatiftab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(BusutilitiesModItems.TICKET_1_VOYAGE.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
