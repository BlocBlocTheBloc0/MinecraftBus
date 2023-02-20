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

import fr.blocblocthebloc.busutilities.world.inventory.StartFr6Menu;
import fr.blocblocthebloc.busutilities.network.StartFr6ButtonMessage;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class StartFr6Screen extends AbstractContainerScreen<StartFr6Menu> {
	private final static HashMap<String, Object> guistate = StartFr6Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_suite;
	Button button_fermer;
	Button button_retour;

	public StartFr6Screen(StartFr6Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 204;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/start_fr_6.png");

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
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_6.label_ticket_durgence"), 56, 7, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_6.label_toutefois_si_vous_navez_pas"), 11, 25, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_6.label_pu_acheter_de_titre_une_option"), 11, 43, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_6.label_est_disponible_pour_vous"), 11, 61, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_6.label_le_ticket_durgence_est"), 11, 79, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_6.label_comme_un_ticket_1_voyage_mais"), 11, 97, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr_6.label_facture_au_prix_de_2_emeraudes"), 11, 115, -12829636);
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
		button_suite = new Button(this.leftPos + 146, this.topPos + 142, 51, 20, Component.translatable("gui.busutilities.start_fr_6.button_suite"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new StartFr6ButtonMessage(0, x, y, z));
				StartFr6ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_suite", button_suite);
		this.addRenderableWidget(button_suite);
		button_fermer = new Button(this.leftPos + 74, this.topPos + 142, 56, 20, Component.translatable("gui.busutilities.start_fr_6.button_fermer"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new StartFr6ButtonMessage(1, x, y, z));
				StartFr6ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_fermer", button_fermer);
		this.addRenderableWidget(button_fermer);
		button_retour = new Button(this.leftPos + 2, this.topPos + 142, 56, 20, Component.translatable("gui.busutilities.start_fr_6.button_retour"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new StartFr6ButtonMessage(2, x, y, z));
				StartFr6ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_retour", button_retour);
		this.addRenderableWidget(button_retour);
	}
}
