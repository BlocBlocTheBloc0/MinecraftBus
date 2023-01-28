
package fr.blocblocthebloc.busutilities.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

import fr.blocblocthebloc.busutilities.world.inventory.ServerCMDGUIMenu;
import fr.blocblocthebloc.busutilities.procedures.WhitelistOnProcedure;
import fr.blocblocthebloc.busutilities.procedures.WhitelistOffProcedure;
import fr.blocblocthebloc.busutilities.procedures.StopserverProcedure;
import fr.blocblocthebloc.busutilities.procedures.SaveallProcedure;
import fr.blocblocthebloc.busutilities.procedures.RestartserverProcedure;
import fr.blocblocthebloc.busutilities.procedures.KickallProcedure;
import fr.blocblocthebloc.busutilities.procedures.ExitGUIProcedure;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ServerCMDGUIButtonMessage {
	private final int buttonID, x, y, z;

	public ServerCMDGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public ServerCMDGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(ServerCMDGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(ServerCMDGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = ServerCMDGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SaveallProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			WhitelistOnProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			KickallProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			WhitelistOffProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			RestartserverProcedure.execute(entity);
		}
		if (buttonID == 5) {

			StopserverProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			ExitGUIProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		BusutilitiesMod.addNetworkMessage(ServerCMDGUIButtonMessage.class, ServerCMDGUIButtonMessage::buffer, ServerCMDGUIButtonMessage::new,
				ServerCMDGUIButtonMessage::handler);
	}
}
