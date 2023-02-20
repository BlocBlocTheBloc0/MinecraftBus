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

import fr.blocblocthebloc.busutilities.world.inventory.StartFr4Menu;
import fr.blocblocthebloc.busutilities.network.StartFr4ButtonMessage;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class StartFr4Screen extends AbstractContainerScreen<StartFr4Menu> {
	private final static HashMap<String, Object> guistate = StartFr4Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_suite;
	Button button_fermer;
	Button button_retour;

	public StartFr4Screen(StartFr4Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 410;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/start_fr_4.png");

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
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_4.label_choses_a_savoir"), 159, 7, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_4.label_abonnement_essentiel"), 6, 25, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_4.label_5_voyages_de_1h"), 24, 52, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_4.label_4_emeraudes"), 33, 88, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_4.label_abonnement_illimite"), 150, 25, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_4.label_voyages_de_1h"), 168, 52, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_4.label_64_emeraudes"), 177, 88, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_4.label_abonnement_10_voyages"), 294, 25, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_4.label_10_voyages_de_1h"), 303, 52, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_4.label_8_emeraudes"), 312, 88, -12829636);
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
		button_suite = new Button(this.leftPos + 348, this.topPos + 142, 51, 20, Component.translatable("gui.busutilities.start_fr_4.button_suite"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new StartFr4ButtonMessage(0, x, y, z));
				StartFr4ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_suite", button_suite);
		this.addRenderableWidget(button_suite);
		button_fermer = new Button(this.leftPos + 177, this.topPos + 142, 56, 20, Component.translatable("gui.busutilities.start_fr_4.button_fermer"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new StartFr4ButtonMessage(1, x, y, z));
				StartFr4ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_fermer", button_fermer);
		this.addRenderableWidget(button_fermer);
		button_retour = new Button(this.leftPos + 6, this.topPos + 142, 56, 20, Component.translatable("gui.busutilities.start_fr_4.button_retour"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new StartFr4ButtonMessage(2, x, y, z));
				StartFr4ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_retour", button_retour);
		this.addRenderableWidget(button_retour);
	}
}
