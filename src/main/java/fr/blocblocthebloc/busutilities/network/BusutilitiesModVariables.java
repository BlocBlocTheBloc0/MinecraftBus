package fr.blocblocthebloc.busutilities.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

import fr.blocblocthebloc.busutilities.BusutilitiesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BusutilitiesModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		BusutilitiesMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new,
				SavedDataSyncMessage::handler);
		BusutilitiesMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
						.syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			clone.Money = original.Money;
			if (!event.isWasDeath()) {
				clone.validite_titre = original.validite_titre;
				clone.CalcV1 = original.CalcV1;
				clone.CalcV2 = original.CalcV2;
				clone.CalcResult = original.CalcResult;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level);
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (mapdata != null)
					BusutilitiesMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()),
							new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					BusutilitiesMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()),
							new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (worlddata != null)
					BusutilitiesMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()),
							new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "busutilities_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				BusutilitiesMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "busutilities_mapvars";
		public String last_ticket_use_name = "\"\"";
		public String last_ticket_use_text = "\"\"";
		public String last_ticket_use_date = "\"\"";
		public String last_ticket_use_heure = "\"\"";
		public String ticket_use_name_1 = "\"\"";
		public String ticket_use_text_1 = "\"\"";
		public String ticket_use_date_1 = "\"\"";
		public String ticket_use_heure_1 = "\"\"";
		public String ticket_use_name_2 = "\"\"";
		public String ticket_use_text_2 = "\"\"";
		public String ticket_use_date_2 = "\"\"";
		public String ticket_use_heure_2 = "\"\"";
		public String ticket_use_name_3 = "\"\"";
		public String ticket_use_text_3 = "\"\"";
		public String ticket_use_date_3 = "\"\"";
		public String ticket_use_heure_3 = "\"\"";
		public String ticket_use_name_4 = "\"\"";
		public String ticket_use_text_4 = "\"\"";
		public String ticket_use_date_4 = "\"\"";
		public String ticket_use_heure_4 = "\"\"";
		public String ticket_use_name_5 = "\"\"";
		public String ticket_use_text_5 = "\"\"";
		public String ticket_use_date_5 = "";
		public String ticket_use_heure_5 = "";
		public String ticket_use_name_6 = "\"\"";
		public String ticket_use_text_6 = "\"\"";
		public String ticket_use_date_6 = "\"\"";
		public String ticket_use_heure_6 = "\"\"";
		public String ticket_use_name_7 = "\"\"";
		public String ticket_use_text_7 = "\"\"";
		public String ticket_use_date_7 = "\"\"";
		public String ticket_use_heure_7 = "\"\"";
		public String ticket_use_name_8 = "\"\"";
		public String ticket_use_text_8 = "\"\"";
		public String ticket_use_date_8 = "";
		public String ticket_use_heure_8 = "\"\"";
		public String ticket_use_name_9 = "\"\"";
		public String ticket_use_text_9 = "\"\"";
		public String ticket_use_date_9 = "\"\"";
		public String ticket_use_heure_9 = "\"\"";
		public String Maintenace_Mode = "\"\"";

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			last_ticket_use_name = nbt.getString("last_ticket_use_name");
			last_ticket_use_text = nbt.getString("last_ticket_use_text");
			last_ticket_use_date = nbt.getString("last_ticket_use_date");
			last_ticket_use_heure = nbt.getString("last_ticket_use_heure");
			ticket_use_name_1 = nbt.getString("ticket_use_name_1");
			ticket_use_text_1 = nbt.getString("ticket_use_text_1");
			ticket_use_date_1 = nbt.getString("ticket_use_date_1");
			ticket_use_heure_1 = nbt.getString("ticket_use_heure_1");
			ticket_use_name_2 = nbt.getString("ticket_use_name_2");
			ticket_use_text_2 = nbt.getString("ticket_use_text_2");
			ticket_use_date_2 = nbt.getString("ticket_use_date_2");
			ticket_use_heure_2 = nbt.getString("ticket_use_heure_2");
			ticket_use_name_3 = nbt.getString("ticket_use_name_3");
			ticket_use_text_3 = nbt.getString("ticket_use_text_3");
			ticket_use_date_3 = nbt.getString("ticket_use_date_3");
			ticket_use_heure_3 = nbt.getString("ticket_use_heure_3");
			ticket_use_name_4 = nbt.getString("ticket_use_name_4");
			ticket_use_text_4 = nbt.getString("ticket_use_text_4");
			ticket_use_date_4 = nbt.getString("ticket_use_date_4");
			ticket_use_heure_4 = nbt.getString("ticket_use_heure_4");
			ticket_use_name_5 = nbt.getString("ticket_use_name_5");
			ticket_use_text_5 = nbt.getString("ticket_use_text_5");
			ticket_use_date_5 = nbt.getString("ticket_use_date_5");
			ticket_use_heure_5 = nbt.getString("ticket_use_heure_5");
			ticket_use_name_6 = nbt.getString("ticket_use_name_6");
			ticket_use_text_6 = nbt.getString("ticket_use_text_6");
			ticket_use_date_6 = nbt.getString("ticket_use_date_6");
			ticket_use_heure_6 = nbt.getString("ticket_use_heure_6");
			ticket_use_name_7 = nbt.getString("ticket_use_name_7");
			ticket_use_text_7 = nbt.getString("ticket_use_text_7");
			ticket_use_date_7 = nbt.getString("ticket_use_date_7");
			ticket_use_heure_7 = nbt.getString("ticket_use_heure_7");
			ticket_use_name_8 = nbt.getString("ticket_use_name_8");
			ticket_use_text_8 = nbt.getString("ticket_use_text_8");
			ticket_use_date_8 = nbt.getString("ticket_use_date_8");
			ticket_use_heure_8 = nbt.getString("ticket_use_heure_8");
			ticket_use_name_9 = nbt.getString("ticket_use_name_9");
			ticket_use_text_9 = nbt.getString("ticket_use_text_9");
			ticket_use_date_9 = nbt.getString("ticket_use_date_9");
			ticket_use_heure_9 = nbt.getString("ticket_use_heure_9");
			Maintenace_Mode = nbt.getString("Maintenace_Mode");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putString("last_ticket_use_name", last_ticket_use_name);
			nbt.putString("last_ticket_use_text", last_ticket_use_text);
			nbt.putString("last_ticket_use_date", last_ticket_use_date);
			nbt.putString("last_ticket_use_heure", last_ticket_use_heure);
			nbt.putString("ticket_use_name_1", ticket_use_name_1);
			nbt.putString("ticket_use_text_1", ticket_use_text_1);
			nbt.putString("ticket_use_date_1", ticket_use_date_1);
			nbt.putString("ticket_use_heure_1", ticket_use_heure_1);
			nbt.putString("ticket_use_name_2", ticket_use_name_2);
			nbt.putString("ticket_use_text_2", ticket_use_text_2);
			nbt.putString("ticket_use_date_2", ticket_use_date_2);
			nbt.putString("ticket_use_heure_2", ticket_use_heure_2);
			nbt.putString("ticket_use_name_3", ticket_use_name_3);
			nbt.putString("ticket_use_text_3", ticket_use_text_3);
			nbt.putString("ticket_use_date_3", ticket_use_date_3);
			nbt.putString("ticket_use_heure_3", ticket_use_heure_3);
			nbt.putString("ticket_use_name_4", ticket_use_name_4);
			nbt.putString("ticket_use_text_4", ticket_use_text_4);
			nbt.putString("ticket_use_date_4", ticket_use_date_4);
			nbt.putString("ticket_use_heure_4", ticket_use_heure_4);
			nbt.putString("ticket_use_name_5", ticket_use_name_5);
			nbt.putString("ticket_use_text_5", ticket_use_text_5);
			nbt.putString("ticket_use_date_5", ticket_use_date_5);
			nbt.putString("ticket_use_heure_5", ticket_use_heure_5);
			nbt.putString("ticket_use_name_6", ticket_use_name_6);
			nbt.putString("ticket_use_text_6", ticket_use_text_6);
			nbt.putString("ticket_use_date_6", ticket_use_date_6);
			nbt.putString("ticket_use_heure_6", ticket_use_heure_6);
			nbt.putString("ticket_use_name_7", ticket_use_name_7);
			nbt.putString("ticket_use_text_7", ticket_use_text_7);
			nbt.putString("ticket_use_date_7", ticket_use_date_7);
			nbt.putString("ticket_use_heure_7", ticket_use_heure_7);
			nbt.putString("ticket_use_name_8", ticket_use_name_8);
			nbt.putString("ticket_use_text_8", ticket_use_text_8);
			nbt.putString("ticket_use_date_8", ticket_use_date_8);
			nbt.putString("ticket_use_heure_8", ticket_use_heure_8);
			nbt.putString("ticket_use_name_9", ticket_use_name_9);
			nbt.putString("ticket_use_text_9", ticket_use_text_9);
			nbt.putString("ticket_use_date_9", ticket_use_date_9);
			nbt.putString("ticket_use_heure_9", ticket_use_heure_9);
			nbt.putString("Maintenace_Mode", Maintenace_Mode);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				BusutilitiesMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e),
						MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("busutilities", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public String validite_titre = "\"\"";
		public double Money = 0;
		public double CalcV1 = 0;
		public double CalcV2 = 0;
		public double CalcResult = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				BusutilitiesMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("validite_titre", validite_titre);
			nbt.putDouble("Money", Money);
			nbt.putDouble("CalcV1", CalcV1);
			nbt.putDouble("CalcV2", CalcV2);
			nbt.putDouble("CalcResult", CalcResult);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			validite_titre = nbt.getString("validite_titre");
			Money = nbt.getDouble("Money");
			CalcV1 = nbt.getDouble("CalcV1");
			CalcV2 = nbt.getDouble("CalcV2");
			CalcResult = nbt.getDouble("CalcResult");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.validite_titre = message.data.validite_titre;
					variables.Money = message.data.Money;
					variables.CalcV1 = message.data.CalcV1;
					variables.CalcV2 = message.data.CalcV2;
					variables.CalcResult = message.data.CalcResult;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
