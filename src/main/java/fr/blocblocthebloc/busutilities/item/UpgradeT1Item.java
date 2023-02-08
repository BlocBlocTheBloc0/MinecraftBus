
package fr.blocblocthebloc.busutilities.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

import fr.blocblocthebloc.busutilities.init.BusutilitiesModTabs;

public class UpgradeT1Item extends Item {
	public UpgradeT1Item() {
		super(new Item.Properties().tab(BusutilitiesModTabs.TAB_CREATIFTAB).stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Utilise pour upgrade le g\u00E9n\u00E9rateur d'argent"));
	}
}
