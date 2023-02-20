package fr.blocblocthebloc.busutilities.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import fr.blocblocthebloc.busutilities.network.BusutilitiesModVariables;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

public class MaintenanceModOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((BusutilitiesModVariables.MapVariables.get(world).Maintenace_Mode).equals("On")) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Le mode maintenance est d\u00E9j\u00E0 activ\u00E9"), (false));
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "whitelist on");
			BusutilitiesMod.queueServerWork(20, () -> {
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(Component.literal("Le serveur entre en maintenance dans 10 secondes"), false);
				}
			});
			BusutilitiesMod.queueServerWork(20, () -> {
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(Component.literal("Le serveur entre en maintenance dans 9 secondes"), false);
				}
			});
			BusutilitiesMod.queueServerWork(20, () -> {
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(Component.literal("Le serveur entre en maintenance dans 8 secondes"), false);
				}
			});
			BusutilitiesMod.queueServerWork(20, () -> {
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(Component.literal("Le serveur entre en maintenance dans 7 secondes"), false);
				}
			});
			BusutilitiesMod.queueServerWork(20, () -> {
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(Component.literal("Le serveur entre en maintenance dans 6 secondes"), false);
				}
			});
			BusutilitiesMod.queueServerWork(20, () -> {
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(Component.literal("Le serveur entre en maintenance dans 5 secondes"), false);
				}
			});
			BusutilitiesMod.queueServerWork(20, () -> {
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(Component.literal("Le serveur entre en maintenance dans 4 secondes"), false);
				}
			});
			BusutilitiesMod.queueServerWork(20, () -> {
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(Component.literal("Le serveur entre en maintenance dans 3 secondes"), false);
				}
			});
			BusutilitiesMod.queueServerWork(20, () -> {
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(Component.literal("Le serveur entre en maintenance dans 2 secondes"), false);
				}
			});
			BusutilitiesMod.queueServerWork(20, () -> {
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(Component.literal("Le serveur entre en maintenance dans 1 secondes"), false);
				}
			});
			BusutilitiesMod.queueServerWork(20, () -> {
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(Component.literal("Le serveur entre en maintenance dans 0 secondes"), false);
				}
			});
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"kick @a Maintenance du serveur");
			BusutilitiesModVariables.MapVariables.get(world).Maintenace_Mode = "On";
			BusutilitiesModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
