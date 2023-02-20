package fr.blocblocthebloc.busutilities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.Calendar;

import fr.blocblocthebloc.busutilities.network.BusutilitiesModVariables;
import fr.blocblocthebloc.busutilities.init.BusutilitiesModItems;

public class VerifCarteIllimiteProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(BusutilitiesModItems.CARTEDETRANSPORT_ILLIMITE.get())) : false) {
			ControleVariableChangeProcedure.execute(world);
			BusutilitiesModVariables.MapVariables.get(world).last_ticket_use_name = entity.getDisplayName().getString();
			BusutilitiesModVariables.MapVariables.get(world).syncData(world);
			BusutilitiesModVariables.MapVariables.get(world).last_ticket_use_text = "Carte type : illimit\u00E9";
			BusutilitiesModVariables.MapVariables.get(world).syncData(world);
			BusutilitiesModVariables.MapVariables.get(world).last_ticket_use_date = new java.text.SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
			BusutilitiesModVariables.MapVariables.get(world).syncData(world);
			BusutilitiesModVariables.MapVariables.get(world).last_ticket_use_heure = Calendar.getInstance().getTime().toString();
			BusutilitiesModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7aTitre de transport valide - Carte : \u00A7k?\u00A7r \u00A7aVoyages Restants"), (true));
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cTitre de transport invalide"), (true));
		}
	}
}
