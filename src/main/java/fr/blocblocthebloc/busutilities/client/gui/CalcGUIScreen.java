
package fr.blocblocthebloc.busutilities.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import fr.blocblocthebloc.busutilities.world.inventory.CalcGUIMenu;
import fr.blocblocthebloc.busutilities.network.CalcGUIButtonMessage;
import fr.blocblocthebloc.busutilities.network.BusutilitiesModVariables;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CalcGUIScreen extends AbstractContainerScreen<CalcGUIMenu> {
	private final static HashMap<String, Object> guistate = CalcGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox Resultat;

	public CalcGUIScreen(CalcGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/calc_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		Resultat.render(ms, mouseX, mouseY, partialTicks);
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
		if (Resultat.isFocused())
			return Resultat.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		Resultat.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Calcule Bloc", 51, 7, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(BusutilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BusutilitiesModVariables.PlayerVariables())).CalcV1) + "", 51, 43, -12829636);
		this.font.draw(poseStack, "+", 78, 43, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(BusutilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BusutilitiesModVariables.PlayerVariables())).CalcV2) + "", 96, 43, -12829636);
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
		Resultat = new EditBox(this.font, this.leftPos + 24, this.topPos + 88, 120, 20, Component.literal(""));
		guistate.put("text:Resultat", Resultat);
		Resultat.setMaxLength(32767);
		this.addWidget(this.Resultat);
		this.addRenderableWidget(new Button(this.leftPos + 51, this.topPos + 124, 67, 20, Component.literal("Calculer"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new CalcGUIButtonMessage(0, x, y, z));
				CalcGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
