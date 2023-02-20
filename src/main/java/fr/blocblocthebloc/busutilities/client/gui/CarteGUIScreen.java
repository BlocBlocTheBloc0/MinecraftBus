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

import fr.blocblocthebloc.busutilities.world.inventory.CarteGUIMenu;
import fr.blocblocthebloc.busutilities.network.CarteGUIButtonMessage;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CarteGUIScreen extends AbstractContainerScreen<CarteGUIMenu> {
	private final static HashMap<String, Object> guistate = CarteGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;

	public CarteGUIScreen(CarteGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 208;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/carte_gui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("busutilities:textures/screens/carte_infite_voayge.png"));
		this.blit(ms, this.leftPos + 181, this.topPos + 163, 0, 0, 32, 32, 32, 32);

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
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_cout_8_emeraudes"), 10, 46, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_temps_de_voyage_1h"), 10, 73, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_nombre_de_voyages_10"), 10, 100, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_lieu_dachat"), 10, 127, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_gare"), 19, 145, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_carte_10_voyages"), 19, 19, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_carte_illimite"), 163, 19, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_cout_64_emeraudes"), 145, 46, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_temps_de_voyage_1h1"), 145, 73, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_nombre_de_voyages"), 145, 100, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_lieu_dachat1"), 145, 127, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_gare1"), 154, 145, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_carte_essensiel"), 298, 19, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_cout_4_emeraudes"), 280, 46, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_temps_de_voyage_1h2"), 280, 73, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_nombre_de_voyages_5"), 280, 100, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_lieu_dachat2"), 280, 127, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carte_gui.label_gare2"), 289, 145, -12829636);
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
		button_empty = new Button(this.leftPos + 1, this.topPos + 181, 30, 20, Component.translatable("gui.busutilities.carte_gui.button_empty"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new CarteGUIButtonMessage(0, x, y, z));
				CarteGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
	}
}
