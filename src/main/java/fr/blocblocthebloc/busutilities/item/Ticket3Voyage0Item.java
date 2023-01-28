
package fr.blocblocthebloc.busutilities.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

import fr.blocblocthebloc.busutilities.init.BusutilitiesModTabs;

public class Ticket3Voyage0Item extends Item {
	public Ticket3Voyage0Item() {
		super(new Item.Properties().tab(BusutilitiesModTabs.TAB_CREATIFTAB).stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Info : 0 Voyage Restant"));
		list.add(Component.literal("Jetez moi dans une poubelle :)"));
	}
}
