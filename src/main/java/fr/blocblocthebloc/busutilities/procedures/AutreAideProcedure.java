package fr.blocblocthebloc.busutilities.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class AutreAideProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("Posez vos question sur notre serveur discord ! https://www.discord.gg/********"), (false));
	}
}
