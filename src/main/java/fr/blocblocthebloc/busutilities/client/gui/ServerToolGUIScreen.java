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

import fr.blocblocthebloc.busutilities.world.inventory.ServerToolGUIMenu;
import fr.blocblocthebloc.busutilities.network.ServerToolGUIButtonMessage;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ServerToolGUIScreen extends AbstractContainerScreen<ServerToolGUIMenu> {
	private final static HashMap<String, Object> guistate = ServerToolGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_exit;
	Button button_server_cmds;
	Button button_busutilities_cmds;
	Button button_maintenance_mode;

	public ServerToolGUIScreen(ServerToolGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/server_tool_gui.png");

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
		this.font.draw(poseStack, Component.translatable("gui.busutilities.server_tool_gui.label_debug_menu"), 60, 7, -12829636);
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
		button_exit = new Button(this.leftPos + 123, this.topPos + 142, 46, 20, Component.translatable("gui.busutilities.server_tool_gui.button_exit"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new ServerToolGUIButtonMessage(0, x, y, z));
				ServerToolGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_exit", button_exit);
		this.addRenderableWidget(button_exit);
		button_server_cmds = new Button(this.leftPos + 42, this.topPos + 61, 82, 20, Component.translatable("gui.busutilities.server_tool_gui.button_server_cmds"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new ServerToolGUIButtonMessage(1, x, y, z));
				ServerToolGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_server_cmds", button_server_cmds);
		this.addRenderableWidget(button_server_cmds);
		button_busutilities_cmds = new Button(this.leftPos + 24, this.topPos + 25, 114, 20, Component.translatable("gui.busutilities.server_tool_gui.button_busutilities_cmds"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new ServerToolGUIButtonMessage(2, x, y, z));
				ServerToolGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_busutilities_cmds", button_busutilities_cmds);
		this.addRenderableWidget(button_busutilities_cmds);
		button_maintenance_mode = new Button(this.leftPos + 33, this.topPos + 97, 108, 20, Component.translatable("gui.busutilities.server_tool_gui.button_maintenance_mode"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new ServerToolGUIButtonMessage(3, x, y, z));
				ServerToolGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_maintenance_mode", button_maintenance_mode);
		this.addRenderableWidget(button_maintenance_mode);
	}
}
