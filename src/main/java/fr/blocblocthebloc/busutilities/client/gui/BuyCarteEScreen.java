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

import fr.blocblocthebloc.busutilities.world.inventory.BuyCarteEMenu;
import fr.blocblocthebloc.busutilities.network.BuyCarteEButtonMessage;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class BuyCarteEScreen extends AbstractContainerScreen<BuyCarteEMenu> {
	private final static HashMap<String, Object> guistate = BuyCarteEMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_acheter;
	Button button_empty;
	Button button_empty1;

	public BuyCarteEScreen(BuyCarteEMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/buy_carte_e.png");

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
		this.font.draw(poseStack, Component.translatable("gui.busutilities.buy_carte_e.label_boutique_abonnements"), 33, 7, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.buy_carte_e.label_type_essentiel"), 42, 16, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.buy_carte_e.label_page_23"), 60, 70, -12829636);
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
		button_acheter = new Button(this.leftPos + 69, this.topPos + 34, 61, 20, Component.translatable("gui.busutilities.buy_carte_e.button_acheter"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new BuyCarteEButtonMessage(0, x, y, z));
				BuyCarteEButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_acheter", button_acheter);
		this.addRenderableWidget(button_acheter);
		button_empty = new Button(this.leftPos + 141, this.topPos + 61, 30, 20, Component.translatable("gui.busutilities.buy_carte_e.button_empty"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new BuyCarteEButtonMessage(1, x, y, z));
				BuyCarteEButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = new Button(this.leftPos + 6, this.topPos + 61, 30, 20, Component.translatable("gui.busutilities.buy_carte_e.button_empty1"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new BuyCarteEButtonMessage(2, x, y, z));
				BuyCarteEButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
	}
}
