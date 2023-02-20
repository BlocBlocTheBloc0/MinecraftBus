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
	Button button_lignes;
	Button button_tickets;
	Button button_lieu;
	Button button_money;
	Button button_credits;
	Button button_autre;

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
		this.font.draw(poseStack, Component.translatable("gui.busutilities.help_menu.label_aide"), 69, 7, -12829636);
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
		button_lignes = new Button(this.leftPos + 6, this.topPos + 25, 56, 20, Component.translatable("gui.busutilities.help_menu.button_lignes"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new HelpMenuButtonMessage(0, x, y, z));
				HelpMenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_lignes", button_lignes);
		this.addRenderableWidget(button_lignes);
		button_tickets = new Button(this.leftPos + 105, this.topPos + 25, 61, 20, Component.translatable("gui.busutilities.help_menu.button_tickets"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new HelpMenuButtonMessage(1, x, y, z));
				HelpMenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_tickets", button_tickets);
		this.addRenderableWidget(button_tickets);
		button_lieu = new Button(this.leftPos + 6, this.topPos + 52, 46, 20, Component.translatable("gui.busutilities.help_menu.button_lieu"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new HelpMenuButtonMessage(2, x, y, z));
				HelpMenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_lieu", button_lieu);
		this.addRenderableWidget(button_lieu);
		button_money = new Button(this.leftPos + 114, this.topPos + 52, 51, 20, Component.translatable("gui.busutilities.help_menu.button_money"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new HelpMenuButtonMessage(3, x, y, z));
				HelpMenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_money", button_money);
		this.addRenderableWidget(button_money);
		button_credits = new Button(this.leftPos + 51, this.topPos + 142, 61, 20, Component.translatable("gui.busutilities.help_menu.button_credits"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new HelpMenuButtonMessage(4, x, y, z));
				HelpMenuButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_credits", button_credits);
		this.addRenderableWidget(button_credits);
		button_autre = new Button(this.leftPos + 240, this.topPos + 178, 51, 20, Component.translatable("gui.busutilities.help_menu.button_autre"), e -> {
		});
		guistate.put("button:button_autre", button_autre);
		this.addRenderableWidget(button_autre);
	}
}
