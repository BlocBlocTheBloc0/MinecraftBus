package fr.blocblocthebloc.busutilities.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.Calendar;

import fr.blocblocthebloc.busutilities.network.BusutilitiesModVariables;
import fr.blocblocthebloc.busutilities.init.BusutilitiesModItems;

public class VerifCarteE2Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem
				? _playerHasItem.getInventory().contains(new ItemStack(BusutilitiesModItems.CARTEDETRANSPORT_2.get()))
				: false) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(BusutilitiesModItems.CARTEDETRANSPORT_1.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(BusutilitiesModItems.CARTEDETRANSPORT_2.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
						_player.inventoryMenu.getCraftSlots());
			}
			ControleVariableChangeProcedure.execute(world);
			BusutilitiesModVariables.MapVariables.get(world).last_ticket_use_name = entity.getDisplayName().getString();
			BusutilitiesModVariables.MapVariables.get(world).syncData(world);
			BusutilitiesModVariables.MapVariables.get(world).last_ticket_use_text = "Carte type : Essential";
			BusutilitiesModVariables.MapVariables.get(world).syncData(world);
			BusutilitiesModVariables.MapVariables.get(world).last_ticket_use_date = new java.text.SimpleDateFormat("dd-MM-yyyy")
					.format(Calendar.getInstance().getTime());
			BusutilitiesModVariables.MapVariables.get(world).syncData(world);
			BusutilitiesModVariables.MapVariables.get(world).last_ticket_use_heure = Calendar.getInstance().getTime().toString();
			BusutilitiesModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7aTitre de transport valide - Carte : 1 Voyages Restants"), (true));
		} else {
			VerifCarteE1Procedure.execute(world, entity);
		}
	}
}
