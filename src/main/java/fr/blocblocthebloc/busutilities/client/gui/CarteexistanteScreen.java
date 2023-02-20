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

import fr.blocblocthebloc.busutilities.world.inventory.CarteexistanteMenu;
import fr.blocblocthebloc.busutilities.network.CarteexistanteButtonMessage;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CarteexistanteScreen extends AbstractContainerScreen<CarteexistanteMenu> {
	private final static HashMap<String, Object> guistate = CarteexistanteMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_jai_une_carte;
	Button button_je_nai_pas_de_carte;
	Button button_x;

	public CarteexistanteScreen(CarteexistanteMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/carteexistante.png");

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
		this.font.draw(poseStack, Component.translatable("gui.busutilities.carteexistante.label_boutique_carte"), 51, 7, -12829636);
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
		button_jai_une_carte = new Button(this.leftPos + 42, this.topPos + 79, 98, 20, Component.translatable("gui.busutilities.carteexistante.button_jai_une_carte"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new CarteexistanteButtonMessage(0, x, y, z));
				CarteexistanteButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_jai_une_carte", button_jai_une_carte);
		this.addRenderableWidget(button_jai_une_carte);
		button_je_nai_pas_de_carte = new Button(this.leftPos + 24, this.topPos + 34, 129, 20, Component.translatable("gui.busutilities.carteexistante.button_je_nai_pas_de_carte"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new CarteexistanteButtonMessage(1, x, y, z));
				CarteexistanteButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_je_nai_pas_de_carte", button_je_nai_pas_de_carte);
		this.addRenderableWidget(button_je_nai_pas_de_carte);
		button_x = new Button(this.leftPos + 141, this.topPos + 142, 30, 20, Component.translatable("gui.busutilities.carteexistante.button_x"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new CarteexistanteButtonMessage(2, x, y, z));
				CarteexistanteButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_x", button_x);
		this.addRenderableWidget(button_x);
	}
}
