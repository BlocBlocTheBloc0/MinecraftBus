
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

import fr.blocblocthebloc.busutilities.world.inventory.LieuGUIMenu;
import fr.blocblocthebloc.busutilities.network.LieuGUIButtonMessage;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class LieuGUIScreen extends AbstractContainerScreen<LieuGUIMenu> {
	private final static HashMap<String, Object> guistate = LieuGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public LieuGUIScreen(LieuGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 260;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/lieu_gui.png");

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
		this.font.draw(poseStack, "Lieu", 120, 6, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 12, this.topPos + 24, 46, 20, Component.literal("Gare"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new LieuGUIButtonMessage(0, x, y, z));
				LieuGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 66, this.topPos + 24, 114, 20, Component.literal("Centre Logistique"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new LieuGUIButtonMessage(1, x, y, z));
				LieuGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 12, this.topPos + 51, 129, 20, Component.literal("Centre Administratif"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new LieuGUIButtonMessage(2, x, y, z));
				LieuGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 147, this.topPos + 51, 98, 20, Component.literal("Magasin Usines"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new LieuGUIButtonMessage(3, x, y, z));
				LieuGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 138, this.topPos + 78, 93, 20, Component.literal("Gare Centrale"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new LieuGUIButtonMessage(4, x, y, z));
				LieuGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 12, this.topPos + 78, 114, 20, Component.literal("Centre Commercial"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new LieuGUIButtonMessage(5, x, y, z));
				LieuGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
	}
}
