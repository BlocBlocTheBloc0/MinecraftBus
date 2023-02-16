
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

import fr.blocblocthebloc.busutilities.world.inventory.LieuGUIMenu;
import fr.blocblocthebloc.busutilities.procedures.MUOPEN0Procedure;
import fr.blocblocthebloc.busutilities.procedures.GareGUI0OpenProcedure;
import fr.blocblocthebloc.busutilities.procedures.CLOpen0Procedure;
import fr.blocblocthebloc.busutilities.procedures.CGOPEN0Procedure;
import fr.blocblocthebloc.busutilities.procedures.CCOPEN0Procedure;
import fr.blocblocthebloc.busutilities.procedures.CAOPEN0Procedure;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LieuGUIButtonMessage {
	private final int buttonID, x, y, z;

	public LieuGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public LieuGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(LieuGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(LieuGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = LieuGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			GareGUI0OpenProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			CLOpen0Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			CAOPEN0Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			MUOPEN0Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			CGOPEN0Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			CCOPEN0Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		BusutilitiesMod.addNetworkMessage(LieuGUIButtonMessage.class, LieuGUIButtonMessage::buffer, LieuGUIButtonMessage::new,
				LieuGUIButtonMessage::handler);
	}
}
