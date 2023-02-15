
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package fr.blocblocthebloc.busutilities.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import fr.blocblocthebloc.busutilities.client.gui.Ticket3VGUIScreen;
import fr.blocblocthebloc.busutilities.client.gui.Ticket1VGUIScreen;
import fr.blocblocthebloc.busutilities.client.gui.Ticket10VGUIScreen;
import fr.blocblocthebloc.busutilities.client.gui.StartlangScreen;
import fr.blocblocthebloc.busutilities.client.gui.StartFrScreen;
import fr.blocblocthebloc.busutilities.client.gui.StartFr9Screen;
import fr.blocblocthebloc.busutilities.client.gui.StartFr8Screen;
import fr.blocblocthebloc.busutilities.client.gui.StartFr7Screen;
import fr.blocblocthebloc.busutilities.client.gui.StartFr6Screen;
import fr.blocblocthebloc.busutilities.client.gui.StartFr5Screen;
import fr.blocblocthebloc.busutilities.client.gui.StartFr4Screen;
import fr.blocblocthebloc.busutilities.client.gui.StartFr3Screen;
import fr.blocblocthebloc.busutilities.client.gui.StartFr2Screen;
import fr.blocblocthebloc.busutilities.client.gui.StartFr1Screen;
import fr.blocblocthebloc.busutilities.client.gui.StartFr0Screen;
import fr.blocblocthebloc.busutilities.client.gui.ShopchoixScreen;
import fr.blocblocthebloc.busutilities.client.gui.ServerToolGUIScreen;
import fr.blocblocthebloc.busutilities.client.gui.ServerCMDGUIScreen;
import fr.blocblocthebloc.busutilities.client.gui.NewsGUIScreen;
import fr.blocblocthebloc.busutilities.client.gui.MoneyRecuGUIScreen;
import fr.blocblocthebloc.busutilities.client.gui.MoneyGUIScreen;
import fr.blocblocthebloc.busutilities.client.gui.MoneyAddGUIScreen;
import fr.blocblocthebloc.busutilities.client.gui.MaintenanceModScreen;
import fr.blocblocthebloc.busutilities.client.gui.HelpMenuScreen;
import fr.blocblocthebloc.busutilities.client.gui.CreateCardScreen;
import fr.blocblocthebloc.busutilities.client.gui.ControleguiScreen;
import fr.blocblocthebloc.busutilities.client.gui.Controlegui9Screen;
import fr.blocblocthebloc.busutilities.client.gui.Controlegui8Screen;
import fr.blocblocthebloc.busutilities.client.gui.Controlegui7Screen;
import fr.blocblocthebloc.busutilities.client.gui.Controlegui6Screen;
import fr.blocblocthebloc.busutilities.client.gui.Controlegui5Screen;
import fr.blocblocthebloc.busutilities.client.gui.Controlegui4Screen;
import fr.blocblocthebloc.busutilities.client.gui.Controlegui3Screen;
import fr.blocblocthebloc.busutilities.client.gui.Controlegui2Screen;
import fr.blocblocthebloc.busutilities.client.gui.Controlegui10Screen;
import fr.blocblocthebloc.busutilities.client.gui.CarteexistanteScreen;
import fr.blocblocthebloc.busutilities.client.gui.CarteGUIScreen;
import fr.blocblocthebloc.busutilities.client.gui.BuyTicket3Screen;
import fr.blocblocthebloc.busutilities.client.gui.BuyTicket1Screen;
import fr.blocblocthebloc.busutilities.client.gui.BuyTicket1ExpressGUIScreen;
import fr.blocblocthebloc.busutilities.client.gui.BuyTicket10Screen;
import fr.blocblocthebloc.busutilities.client.gui.BuyCarteIllimiteScreen;
import fr.blocblocthebloc.busutilities.client.gui.BuyCarteEScreen;
import fr.blocblocthebloc.busutilities.client.gui.BuyCarte10Screen;
import fr.blocblocthebloc.busutilities.client.gui.BusUtilitiesCMDGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BusutilitiesModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(BusutilitiesModMenus.CONTROLEGUI.get(), ControleguiScreen::new);
			MenuScreens.register(BusutilitiesModMenus.CONTROLEGUI_2.get(), Controlegui2Screen::new);
			MenuScreens.register(BusutilitiesModMenus.CONTROLEGUI_3.get(), Controlegui3Screen::new);
			MenuScreens.register(BusutilitiesModMenus.CONTROLEGUI_4.get(), Controlegui4Screen::new);
			MenuScreens.register(BusutilitiesModMenus.CONTROLEGUI_5.get(), Controlegui5Screen::new);
			MenuScreens.register(BusutilitiesModMenus.SERVER_TOOL_GUI.get(), ServerToolGUIScreen::new);
			MenuScreens.register(BusutilitiesModMenus.BUS_UTILITIES_CMDGUI.get(), BusUtilitiesCMDGUIScreen::new);
			MenuScreens.register(BusutilitiesModMenus.SERVER_CMDGUI.get(), ServerCMDGUIScreen::new);
			MenuScreens.register(BusutilitiesModMenus.CONTROLEGUI_6.get(), Controlegui6Screen::new);
			MenuScreens.register(BusutilitiesModMenus.CONTROLEGUI_7.get(), Controlegui7Screen::new);
			MenuScreens.register(BusutilitiesModMenus.CONTROLEGUI_8.get(), Controlegui8Screen::new);
			MenuScreens.register(BusutilitiesModMenus.CONTROLEGUI_9.get(), Controlegui9Screen::new);
			MenuScreens.register(BusutilitiesModMenus.CONTROLEGUI_10.get(), Controlegui10Screen::new);
			MenuScreens.register(BusutilitiesModMenus.MAINTENANCE_MOD.get(), MaintenanceModScreen::new);
			MenuScreens.register(BusutilitiesModMenus.SHOPCHOIX.get(), ShopchoixScreen::new);
			MenuScreens.register(BusutilitiesModMenus.BUY_TICKET_1.get(), BuyTicket1Screen::new);
			MenuScreens.register(BusutilitiesModMenus.BUY_TICKET_3.get(), BuyTicket3Screen::new);
			MenuScreens.register(BusutilitiesModMenus.BUY_TICKET_10.get(), BuyTicket10Screen::new);
			MenuScreens.register(BusutilitiesModMenus.CARTEEXISTANTE.get(), CarteexistanteScreen::new);
			MenuScreens.register(BusutilitiesModMenus.CREATE_CARD.get(), CreateCardScreen::new);
			MenuScreens.register(BusutilitiesModMenus.BUY_CARTE_10.get(), BuyCarte10Screen::new);
			MenuScreens.register(BusutilitiesModMenus.BUY_CARTE_E.get(), BuyCarteEScreen::new);
			MenuScreens.register(BusutilitiesModMenus.BUY_CARTE_ILLIMITE.get(), BuyCarteIllimiteScreen::new);
			MenuScreens.register(BusutilitiesModMenus.MONEY_GUI.get(), MoneyGUIScreen::new);
			MenuScreens.register(BusutilitiesModMenus.MONEY_ADD_GUI.get(), MoneyAddGUIScreen::new);
			MenuScreens.register(BusutilitiesModMenus.MONEY_RECU_GUI.get(), MoneyRecuGUIScreen::new);
			MenuScreens.register(BusutilitiesModMenus.BUY_TICKET_1_EXPRESS_GUI.get(), BuyTicket1ExpressGUIScreen::new);
			MenuScreens.register(BusutilitiesModMenus.NEWS_GUI.get(), NewsGUIScreen::new);
			MenuScreens.register(BusutilitiesModMenus.STARTLANG.get(), StartlangScreen::new);
			MenuScreens.register(BusutilitiesModMenus.START_FR.get(), StartFrScreen::new);
			MenuScreens.register(BusutilitiesModMenus.START_FR_0.get(), StartFr0Screen::new);
			MenuScreens.register(BusutilitiesModMenus.START_FR_1.get(), StartFr1Screen::new);
			MenuScreens.register(BusutilitiesModMenus.START_FR_2.get(), StartFr2Screen::new);
			MenuScreens.register(BusutilitiesModMenus.START_FR_3.get(), StartFr3Screen::new);
			MenuScreens.register(BusutilitiesModMenus.START_FR_4.get(), StartFr4Screen::new);
			MenuScreens.register(BusutilitiesModMenus.START_FR_5.get(), StartFr5Screen::new);
			MenuScreens.register(BusutilitiesModMenus.START_FR_6.get(), StartFr6Screen::new);
			MenuScreens.register(BusutilitiesModMenus.START_FR_7.get(), StartFr7Screen::new);
			MenuScreens.register(BusutilitiesModMenus.START_FR_8.get(), StartFr8Screen::new);
			MenuScreens.register(BusutilitiesModMenus.START_FR_9.get(), StartFr9Screen::new);
			MenuScreens.register(BusutilitiesModMenus.HELP_MENU.get(), HelpMenuScreen::new);
			MenuScreens.register(BusutilitiesModMenus.TICKET_1_VGUI.get(), Ticket1VGUIScreen::new);
			MenuScreens.register(BusutilitiesModMenus.TICKET_3_VGUI.get(), Ticket3VGUIScreen::new);
			MenuScreens.register(BusutilitiesModMenus.TICKET_10_VGUI.get(), Ticket10VGUIScreen::new);
			MenuScreens.register(BusutilitiesModMenus.CARTE_GUI.get(), CarteGUIScreen::new);
		});
	}
}
