package fr.blocblocthebloc.busutilities.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class LignesAccesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("L'int\u00E9gralit\u00E9 des lignes de la map sont disponible dans le salon #lignes du serveur discord du projet : https://www.discord.gg/********"), (false));
	}
}
