package fr.blocblocthebloc.busutilities.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class MoneyGen2Procedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 200);
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(Items.EMERALD);
			_setstack.setCount(2);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}
