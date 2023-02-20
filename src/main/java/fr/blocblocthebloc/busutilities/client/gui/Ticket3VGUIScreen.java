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

import fr.blocblocthebloc.busutilities.world.inventory.Ticket3VGUIMenu;
import fr.blocblocthebloc.busutilities.network.Ticket3VGUIButtonMessage;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class Ticket3VGUIScreen extends AbstractContainerScreen<Ticket3VGUIMenu> {
	private final static HashMap<String, Object> guistate = Ticket3VGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	Button button_empty1;

	public Ticket3VGUIScreen(Ticket3VGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 208;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/ticket_3_vgui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("busutilities:textures/screens/ticket_3_voayge.png"));
		this.blit(ms, this.leftPos + 24, this.topPos + 1, 0, 0, 32, 32, 32, 32);

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
		this.font.draw(poseStack, Component.translatable("gui.busutilities.ticket_3_vgui.label_ticket_3_voyages"), 69, 10, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.ticket_3_vgui.label_cout_3_emeraudes"), 24, 37, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.ticket_3_vgui.label_temps_de_voyage_1h"), 24, 64, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.ticket_3_vgui.label_nombre_de_voyages_3"), 24, 91, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.ticket_3_vgui.label_lieu_dachat"), 24, 118, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.ticket_3_vgui.label_gare"), 33, 136, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.ticket_3_vgui.label_point_de_vente"), 33, 154, -12829636);
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
		button_empty = new Button(this.leftPos + 141, this.topPos + 181, 30, 20, Component.translatable("gui.busutilities.ticket_3_vgui.button_empty"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new Ticket3VGUIButtonMessage(0, x, y, z));
				Ticket3VGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = new Button(this.leftPos + 6, this.topPos + 181, 30, 20, Component.translatable("gui.busutilities.ticket_3_vgui.button_empty1"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new Ticket3VGUIButtonMessage(1, x, y, z));
				Ticket3VGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
	}
}
