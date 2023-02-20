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

import fr.blocblocthebloc.busutilities.world.inventory.StartFrMenu;
import fr.blocblocthebloc.busutilities.network.StartFrButtonMessage;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class StartFrScreen extends AbstractContainerScreen<StartFrMenu> {
	private final static HashMap<String, Object> guistate = StartFrMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_suite;
	Button button_fermer;

	public StartFrScreen(StartFrMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 204;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/start_fr.png");

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
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr.label_bienvenue_sur_la_map_minecraftbu"), 10, 5, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr.label_sur_cette_map_vous_allez"), 11, 25, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr.label_pouvoir_experimenter_le_systeme"), 11, 43, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr.label_de_transport_en_commun_sur_minec"), 11, 61, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.start_fr.label_avec_les_trains_du_mod_create"), 11, 79, -12829636);
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
		button_suite = new Button(this.leftPos + 146, this.topPos + 142, 51, 20, Component.translatable("gui.busutilities.start_fr.button_suite"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new StartFrButtonMessage(0, x, y, z));
				StartFrButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_suite", button_suite);
		this.addRenderableWidget(button_suite);
		button_fermer = new Button(this.leftPos + 74, this.topPos + 142, 56, 20, Component.translatable("gui.busutilities.start_fr.button_fermer"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new StartFrButtonMessage(1, x, y, z));
				StartFrButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_fermer", button_fermer);
		this.addRenderableWidget(button_fermer);
	}
}
