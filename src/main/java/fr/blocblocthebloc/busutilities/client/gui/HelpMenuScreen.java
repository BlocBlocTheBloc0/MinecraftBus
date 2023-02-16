
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

import fr.blocblocthebloc.busutilities.world.inventory.HelpMenuMenu;
import fr.blocblocthebloc.busutilities.network.HelpMenuButtonMessage;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class HelpMenuScreen extends AbstractContainerScreen<HelpMenuMenu> {
	private final static HashMap<String, Object> guistate = HelpMenuMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public HelpMenuScreen(HelpMenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/help_menu.png");

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
		this.font.draw(poseStack, "Aide", 69, 7, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 25, 56, 20, Component.literal("Lignes"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new HelpMenuButtonMessage(0, x, y, z));
				HelpMenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 105, this.topPos + 25, 61, 20, Component.literal("Tickets"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new HelpMenuButtonMessage(1, x, y, z));
				HelpMenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 52, 46, 20, Component.literal("Lieu"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new HelpMenuButtonMessage(2, x, y, z));
				HelpMenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 114, this.topPos + 52, 51, 20, Component.literal("Money"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new HelpMenuButtonMessage(3, x, y, z));
				HelpMenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 51, this.topPos + 142, 61, 20, Component.literal("Crédits"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 240, this.topPos + 178, 51, 20, Component.literal("Autre"), e -> {
		}));
	}
}
