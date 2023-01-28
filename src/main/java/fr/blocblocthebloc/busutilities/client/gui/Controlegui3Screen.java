
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

import fr.blocblocthebloc.busutilities.world.inventory.Controlegui3Menu;
import fr.blocblocthebloc.busutilities.network.Controlegui3ButtonMessage;
import fr.blocblocthebloc.busutilities.network.BusutilitiesModVariables;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class Controlegui3Screen extends AbstractContainerScreen<Controlegui3Menu> {
	private final static HashMap<String, Object> guistate = Controlegui3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public Controlegui3Screen(Controlegui3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 220;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("busutilities:textures/screens/controlegui_3.png");

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
		this.font.draw(poseStack, "" + (BusutilitiesModVariables.MapVariables.get(world).ticket_use_name_2) + "", 37, 15, -12829636);
		this.font.draw(poseStack, "" + (BusutilitiesModVariables.MapVariables.get(world).ticket_use_text_2) + "", 37, 51, -12829636);
		this.font.draw(poseStack, "" + (BusutilitiesModVariables.MapVariables.get(world).ticket_use_date_2) + "", 37, 96, -12829636);
		this.font.draw(poseStack, "" + (BusutilitiesModVariables.MapVariables.get(world).ticket_use_heure_2) + "", 37, 132, -12829636);
		this.font.draw(poseStack, "Page 3/10", 91, 177, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 181, this.topPos + 168, 30, 20, Component.literal(">"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new Controlegui3ButtonMessage(0, x, y, z));
				Controlegui3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 10, this.topPos + 168, 30, 20, Component.literal("<"), e -> {
			if (true) {
				BusutilitiesMod.PACKET_HANDLER.sendToServer(new Controlegui3ButtonMessage(1, x, y, z));
				Controlegui3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
