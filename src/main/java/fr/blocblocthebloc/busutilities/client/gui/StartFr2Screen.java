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

import fr.blocblocthebloc.busutilities.world.inventory.StartFr2Menu;
import fr.blocblocthebloc.busutilities.network.StartFr2ButtonMessage;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class StartFr2Screen extends AbstractContainerScreen<StartFr2Menu> {
	private final static HashMap<String, Object> guistate = StartFr2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_suite;
	Button button_fermer;
	Button button_retour;

	public StartFr2Screen(StartFr2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 410;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/start_fr_2.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("busutilities:textures/screens/ticket_1_voyage.png"));
		this.blit(ms, this.leftPos + 24, this.topPos + 43, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("busutilities:textures/screens/ticket_3_voayge.png"));
		this.blit(ms, this.leftPos + 186, this.topPos + 43, 0, 0, 32, 32, 32, 32);

		RenderSystem.setShaderTexture(0, new ResourceLocation("busutilities:textures/screens/ticket_10_voyage.png"));
		this.blit(ms, this.leftPos + 330, this.topPos + 43, 0, 0, 32, 32, 32, 32);

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
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_2.label_choses_a_savoir"), 159, 7, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_2.label_ticket_1_voyage"), 6, 25, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_2.label_1_voyage_de_1h"), 6, 79, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_2.label_1_emeraude"), 15, 106, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_2.label_ticket_3_voyages"), 159, 25, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_2.label_3_voyages_de_1h"), 168, 79, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_2.label_3_emeraudes"), 177, 106, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_2.label_ticket_10_voyages"), 294, 25, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_2.label_10_voyages_de_1h"), 303, 79, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_2.label_10_emeraudes"), 312, 106, -12829636);
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
		button_suite = new Button(this.leftPos + 348, this.topPos + 142, 51, 20, Component.translatable("gui.busutilities.start_fr_2.button_suite"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new StartFr2ButtonMessage(0, x, y, z));
				StartFr2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_suite", button_suite);
		this.addRenderableWidget(button_suite);
		button_fermer = new Button(this.leftPos + 177, this.topPos + 142, 56, 20, Component.translatable("gui.busutilities.start_fr_2.button_fermer"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new StartFr2ButtonMessage(1, x, y, z));
				StartFr2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_fermer", button_fermer);
		this.addRenderableWidget(button_fermer);
		button_retour = new Button(this.leftPos + 6, this.topPos + 142, 56, 20, Component.translatable("gui.busutilities.start_fr_2.button_retour"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new StartFr2ButtonMessage(2, x, y, z));
				StartFr2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_retour", button_retour);
		this.addRenderableWidget(button_retour);
	}
}
