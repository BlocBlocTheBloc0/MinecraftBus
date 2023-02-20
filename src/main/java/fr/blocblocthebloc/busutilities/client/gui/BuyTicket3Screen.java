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

import fr.blocblocthebloc.busutilities.world.inventory.BuyTicket3Menu;
import fr.blocblocthebloc.busutilities.network.BuyTicket3ButtonMessage;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class BuyTicket3Screen extends AbstractContainerScreen<BuyTicket3Menu> {
	private final static HashMap<String, Object> guistate = BuyTicket3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	Button button_acheter;
	Button button_empty1;

	public BuyTicket3Screen(BuyTicket3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/buy_ticket_3.png");

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
		this.font.draw(poseStack, Component.translatable("gui.busutilities.buy_ticket_3.label_boutique_ticket_3_voyages"), 24, 7, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.buy_ticket_3.label_page_23"), 60, 70, -12829636);
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
		button_empty = new Button(this.leftPos + 141, this.topPos + 61, 30, 20, Component.translatable("gui.busutilities.buy_ticket_3.button_empty"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new BuyTicket3ButtonMessage(0, x, y, z));
				BuyTicket3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_acheter = new Button(this.leftPos + 51, this.topPos + 25, 61, 20, Component.translatable("gui.busutilities.buy_ticket_3.button_acheter"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new BuyTicket3ButtonMessage(1, x, y, z));
				BuyTicket3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_acheter", button_acheter);
		this.addRenderableWidget(button_acheter);
		button_empty1 = new Button(this.leftPos + 6, this.topPos + 61, 30, 20, Component.translatable("gui.busutilities.buy_ticket_3.button_empty1"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new BuyTicket3ButtonMessage(2, x, y, z));
				BuyTicket3ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
	}
}
