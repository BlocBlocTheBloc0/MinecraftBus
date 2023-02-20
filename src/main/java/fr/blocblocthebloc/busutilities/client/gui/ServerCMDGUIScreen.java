package fr.blocblocthebloc.busutilities.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import fr.blocblocthebloc.busutilities.world.inventory.ServerCMDGUIMenu;
import fr.blocblocthebloc.busutilities.network.ServerCMDGUIButtonMessage;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ServerCMDGUIScreen extends AbstractContainerScreen<ServerCMDGUIMenu> {
	private final static HashMap<String, Object> guistate = ServerCMDGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_save_all;
	Button button_set_whitelist_on;
	Button button_kick_all;
	Button button_set_whitelist_off;
	Button button_restart_server;
	Button button_stop_server;
	Button button_x;

	public ServerCMDGUIScreen(ServerCMDGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/server_cmdgui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.busutilities.server_cmdgui.label_server_cmds"), 60, 7, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_save_all = new Button(this.leftPos + 15, this.topPos + 25, 66, 20, Component.translatable("gui.busutilities.server_cmdgui.button_save_all"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new ServerCMDGUIButtonMessage(0, x, y, z));
				ServerCMDGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_save_all", button_save_all);
		this.addRenderableWidget(button_save_all);
		button_set_whitelist_on = new Button(this.leftPos + 15, this.topPos + 52, 108, 20, Component.translatable("gui.busutilities.server_cmdgui.button_set_whitelist_on"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new ServerCMDGUIButtonMessage(1, x, y, z));
				ServerCMDGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_set_whitelist_on", button_set_whitelist_on);
		this.addRenderableWidget(button_set_whitelist_on);
		button_kick_all = new Button(this.leftPos + 96, this.topPos + 25, 66, 20, Component.translatable("gui.busutilities.server_cmdgui.button_kick_all"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new ServerCMDGUIButtonMessage(2, x, y, z));
				ServerCMDGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_kick_all", button_kick_all);
		this.addRenderableWidget(button_kick_all);
		button_set_whitelist_off = new Button(this.leftPos + 15, this.topPos + 79, 113, 20, Component.translatable("gui.busutilities.server_cmdgui.button_set_whitelist_off"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new ServerCMDGUIButtonMessage(3, x, y, z));
				ServerCMDGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_set_whitelist_off", button_set_whitelist_off);
		this.addRenderableWidget(button_set_whitelist_off);
		button_restart_server = new Button(this.leftPos + 15, this.topPos + 106, 98, 20, Component.translatable("gui.busutilities.server_cmdgui.button_restart_server"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new ServerCMDGUIButtonMessage(4, x, y, z));
				ServerCMDGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_restart_server", button_restart_server);
		this.addRenderableWidget(button_restart_server);
		button_stop_server = new Button(this.leftPos + 15, this.topPos + 133, 82, 20, Component.translatable("gui.busutilities.server_cmdgui.button_stop_server"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new ServerCMDGUIButtonMessage(5, x, y, z));
				ServerCMDGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:button_stop_server", button_stop_server);
		this.addRenderableWidget(button_stop_server);
		button_x = new Button(this.leftPos + 141, this.topPos + 142, 30, 20, Component.translatable("gui.busutilities.server_cmdgui.button_x"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new ServerCMDGUIButtonMessage(6, x, y, z));
				ServerCMDGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:button_x", button_x);
		this.addRenderableWidget(button_x);
	}
}
