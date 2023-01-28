
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

import fr.blocblocthebloc.busutilities.world.inventory.MaintenanceModMenu;
import fr.blocblocthebloc.busutilities.network.MaintenanceModButtonMessage;
import fr.blocblocthebloc.busutilities.network.BusutilitiesModVariables;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class MaintenanceModScreen extends AbstractContainerScreen<MaintenanceModMenu> {
	private final static HashMap<String, Object> guistate = MaintenanceModMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public MaintenanceModScreen(MaintenanceModMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/maintenance_mod.png");

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
		this.font.draw(poseStack, "Maintenance GUI", 42, 7, -12829636);
		this.font.draw(poseStack, "Maintenance Mode is : ", 15, 25, -12829636);
		this.font.draw(poseStack, "" + (BusutilitiesModVariables.MapVariables.get(world).Maintenace_Mode) + "", 132, 25, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 141, this.topPos + 142, 30, 20, Component.literal("X"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new MaintenanceModButtonMessage(0, x, y, z));
				MaintenanceModButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 51, this.topPos + 52, 71, 20, Component.literal("Set to ON"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new MaintenanceModButtonMessage(1, x, y, z));
				MaintenanceModButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 51, this.topPos + 97, 77, 20, Component.literal("Set to OFF"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new MaintenanceModButtonMessage(2, x, y, z));
				MaintenanceModButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
