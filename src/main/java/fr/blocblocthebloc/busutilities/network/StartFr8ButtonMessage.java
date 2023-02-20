
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

import fr.blocblocthebloc.busutilities.world.inventory.StartFr8Menu;
import fr.blocblocthebloc.busutilities.procedures.StartFrOp9Procedure;
import fr.blocblocthebloc.busutilities.procedures.StartFrOp7Procedure;
import fr.blocblocthebloc.busutilities.procedures.ExitGUIProcedure;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StartFr8ButtonMessage {
	private final int buttonID, x, y, z;

	public StartFr8ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public StartFr8ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(StartFr8ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(StartFr8ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = StartFr8Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			StartFrOp9Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ExitGUIProcedure.execute(entity);
		}
		if (buttonID == 2) {

			StartFrOp7Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		BusutilitiesMod.addNetworkMessage(StartFr8ButtonMessage.class, StartFr8ButtonMessage::buffer, StartFr8ButtonMessage::new, StartFr8ButtonMessage::handler);
	}
}
