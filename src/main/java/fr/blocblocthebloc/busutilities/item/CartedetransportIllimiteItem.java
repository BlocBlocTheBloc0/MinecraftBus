
package fr.blocblocthebloc.busutilities.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

import fr.blocblocthebloc.busutilities.init.BusutilitiesModTabs;

public class CartedetransportIllimiteItem extends Item {
	public CartedetransportIllimiteItem() {
		super(new Item.Properties().tab(BusutilitiesModTabs.TAB_CREATIFTAB).stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Abonnement : Illimit\u00E9"));
		list.add(Component.literal("Info : \u00A7k-1\u00A7r Voyage Restant"));
	}
}
