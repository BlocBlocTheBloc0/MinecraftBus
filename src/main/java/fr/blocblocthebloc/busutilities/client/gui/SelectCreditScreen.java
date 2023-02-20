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

import fr.blocblocthebloc.busutilities.world.inventory.SelectCreditMenu;
import fr.blocblocthebloc.busutilities.network.SelectCreditButtonMessage;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class SelectCreditScreen extends AbstractContainerScreen<SelectCreditMenu> {
	private final static HashMap<String, Object> guistate = SelectCreditMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_la_map;
	Button button_serveur;
	Button button_busutilitiessoundsverif;
	Button button_create;
	Button button_jei;
	Button button_the_one_probe;
	Button button_optifine;

	public SelectCreditScreen(SelectCreditMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/select_credit.png");

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
		this.font.draw(poseStack, Component.translatable("gui.busutilities.select_credit.label_selection_du_credit"), 33, 7, -12829636);
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
		button_la_map = new Button(this.leftPos + 6, this.topPos + 25, 56, 20, Component.translatable("gui.busutilities.select_credit.button_la_map"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new SelectCreditButtonMessage(0, x, y, z));
				SelectCreditButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_la_map", button_la_map);
		this.addRenderableWidget(button_la_map);
		button_serveur = new Button(this.leftPos + 69, this.topPos + 25, 61, 20, Component.translatable("gui.busutilities.select_credit.button_serveur"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new SelectCreditButtonMessage(1, x, y, z));
				SelectCreditButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_serveur", button_serveur);
		this.addRenderableWidget(button_serveur);
		button_busutilitiessoundsverif = new Button(this.leftPos + 6, this.topPos + 52, 156, 20, Component.translatable("gui.busutilities.select_credit.button_busutilitiessoundsverif"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new SelectCreditButtonMessage(2, x, y, z));
				SelectCreditButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_busutilitiessoundsverif", button_busutilitiessoundsverif);
		this.addRenderableWidget(button_busutilitiessoundsverif);
		button_create = new Button(this.leftPos + 6, this.topPos + 79, 56, 20, Component.translatable("gui.busutilities.select_credit.button_create"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new SelectCreditButtonMessage(3, x, y, z));
				SelectCreditButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_create", button_create);
		this.addRenderableWidget(button_create);
		button_jei = new Button(this.leftPos + 69, this.topPos + 79, 40, 20, Component.translatable("gui.busutilities.select_credit.button_jei"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new SelectCreditButtonMessage(4, x, y, z));
				SelectCreditButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_jei", button_jei);
		this.addRenderableWidget(button_jei);
		button_the_one_probe = new Button(this.leftPos + 6, this.topPos + 106, 92, 20, Component.translatable("gui.busutilities.select_credit.button_the_one_probe"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new SelectCreditButtonMessage(5, x, y, z));
				SelectCreditButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:button_the_one_probe", button_the_one_probe);
		this.addRenderableWidget(button_the_one_probe);
		button_optifine = new Button(this.leftPos + 6, this.topPos + 133, 67, 20, Component.translatable("gui.busutilities.select_credit.button_optifine"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new SelectCreditButtonMessage(6, x, y, z));
				SelectCreditButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:button_optifine", button_optifine);
		this.addRenderableWidget(button_optifine);
	}
}
