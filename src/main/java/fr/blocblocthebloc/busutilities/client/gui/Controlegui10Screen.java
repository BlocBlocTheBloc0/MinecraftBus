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

import fr.blocblocthebloc.busutilities.world.inventory.Controlegui10Menu;
import fr.blocblocthebloc.busutilities.network.Controlegui10ButtonMessage;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class Controlegui10Screen extends AbstractContainerScreen<Controlegui10Menu> {
	private final static HashMap<String, Object> guistate = Controlegui10Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;

	public Controlegui10Screen(Controlegui10Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 220;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/controlegui_10.png");

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
		this.font.draw(poseStack, Component.translatable("gui.busutilities.controlegui_10.label_varticket_use_name_9"), 37, 15, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.controlegui_10.label_varticket_use_text_9"), 37, 51, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.controlegui_10.label_varticket_use_date_9"), 37, 96, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.controlegui_10.label_varticket_use_heure_9"), 37, 132, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.busutilities.controlegui_10.label_page_1010"), 91, 177, -12829636);
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
		button_empty = new Button(this.leftPos + 10, this.topPos + 168, 30, 20, Component.translatable("gui.busutilities.controlegui_10.button_empty"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new Controlegui10ButtonMessage(0, x, y, z));
				Controlegui10ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
	}
}
