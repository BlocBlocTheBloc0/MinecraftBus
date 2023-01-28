
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

import fr.blocblocthebloc.busutilities.world.inventory.BuyCarte10Menu;
import fr.blocblocthebloc.busutilities.network.BuyCarte10ButtonMessage;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class BuyCarte10Screen extends AbstractContainerScreen<BuyCarte10Menu> {
	private final static HashMap<String, Object> guistate = BuyCarte10Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public BuyCarte10Screen(BuyCarte10Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/buy_carte_10.png");

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
		this.font.draw(poseStack, "Boutique Abonnements", 33, 7, -12829636);
		this.font.draw(poseStack, "Type : 10 Voyages", 42, 16, -12829636);
		this.font.draw(poseStack, "Page : 1/3", 60, 70, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 69, this.topPos + 34, 61, 20, Component.literal("Acheter"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new BuyCarte10ButtonMessage(0, x, y, z));
				BuyCarte10ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 141, this.topPos + 61, 30, 20, Component.literal(">"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new BuyCarte10ButtonMessage(1, x, y, z));
				BuyCarte10ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
