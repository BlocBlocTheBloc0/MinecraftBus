
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package fr.blocblocthebloc.busutilities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import fr.blocblocthebloc.busutilities.world.inventory.Ticket3VGUIMenu;
import fr.blocblocthebloc.busutilities.world.inventory.Ticket1VGUIMenu;
import fr.blocblocthebloc.busutilities.world.inventory.Ticket10VGUIMenu;
import fr.blocblocthebloc.busutilities.world.inventory.StartlangMenu;
import fr.blocblocthebloc.busutilities.world.inventory.StartFrMenu;
import fr.blocblocthebloc.busutilities.world.inventory.StartFr9Menu;
import fr.blocblocthebloc.busutilities.world.inventory.StartFr8Menu;
import fr.blocblocthebloc.busutilities.world.inventory.StartFr7Menu;
import fr.blocblocthebloc.busutilities.world.inventory.StartFr6Menu;
import fr.blocblocthebloc.busutilities.world.inventory.StartFr5Menu;
import fr.blocblocthebloc.busutilities.world.inventory.StartFr4Menu;
import fr.blocblocthebloc.busutilities.world.inventory.StartFr3Menu;
import fr.blocblocthebloc.busutilities.world.inventory.StartFr2Menu;
import fr.blocblocthebloc.busutilities.world.inventory.StartFr1Menu;
import fr.blocblocthebloc.busutilities.world.inventory.StartFr0Menu;
import fr.blocblocthebloc.busutilities.world.inventory.ShopchoixMenu;
import fr.blocblocthebloc.busutilities.world.inventory.ServerToolGUIMenu;
import fr.blocblocthebloc.busutilities.world.inventory.ServerCMDGUIMenu;
import fr.blocblocthebloc.busutilities.world.inventory.NewsGUIMenu;
import fr.blocblocthebloc.busutilities.world.inventory.MoneyRecuGUIMenu;
import fr.blocblocthebloc.busutilities.world.inventory.MoneyGUIMenu;
import fr.blocblocthebloc.busutilities.world.inventory.MoneyAddGUIMenu;
import fr.blocblocthebloc.busutilities.world.inventory.MaintenanceModMenu;
import fr.blocblocthebloc.busutilities.world.inventory.HelpMenuMenu;
import fr.blocblocthebloc.busutilities.world.inventory.CreateCardMenu;
import fr.blocblocthebloc.busutilities.world.inventory.ControleguiMenu;
import fr.blocblocthebloc.busutilities.world.inventory.Controlegui9Menu;
import fr.blocblocthebloc.busutilities.world.inventory.Controlegui8Menu;
import fr.blocblocthebloc.busutilities.world.inventory.Controlegui7Menu;
import fr.blocblocthebloc.busutilities.world.inventory.Controlegui6Menu;
import fr.blocblocthebloc.busutilities.world.inventory.Controlegui5Menu;
import fr.blocblocthebloc.busutilities.world.inventory.Controlegui4Menu;
import fr.blocblocthebloc.busutilities.world.inventory.Controlegui3Menu;
import fr.blocblocthebloc.busutilities.world.inventory.Controlegui2Menu;
import fr.blocblocthebloc.busutilities.world.inventory.Controlegui10Menu;
import fr.blocblocthebloc.busutilities.world.inventory.CarteexistanteMenu;
import fr.blocblocthebloc.busutilities.world.inventory.CarteGUIMenu;
import fr.blocblocthebloc.busutilities.world.inventory.BuyTicket3Menu;
import fr.blocblocthebloc.busutilities.world.inventory.BuyTicket1Menu;
import fr.blocblocthebloc.busutilities.world.inventory.BuyTicket1ExpressGUIMenu;
import fr.blocblocthebloc.busutilities.world.inventory.BuyTicket10Menu;
import fr.blocblocthebloc.busutilities.world.inventory.BuyCarteIllimiteMenu;
import fr.blocblocthebloc.busutilities.world.inventory.BuyCarteEMenu;
import fr.blocblocthebloc.busutilities.world.inventory.BuyCarte10Menu;
import fr.blocblocthebloc.busutilities.world.inventory.BusUtilitiesCMDGUIMenu;
import fr.blocblocthebloc.busutilities.BusutilitiesMod;

public class BusutilitiesModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, BusutilitiesMod.MODID);
	public static final RegistryObject<MenuType<ControleguiMenu>> CONTROLEGUI = REGISTRY.register("controlegui",
			() -> IForgeMenuType.create(ControleguiMenu::new));
	public static final RegistryObject<MenuType<Controlegui2Menu>> CONTROLEGUI_2 = REGISTRY.register("controlegui_2",
			() -> IForgeMenuType.create(Controlegui2Menu::new));
	public static final RegistryObject<MenuType<Controlegui3Menu>> CONTROLEGUI_3 = REGISTRY.register("controlegui_3",
			() -> IForgeMenuType.create(Controlegui3Menu::new));
	public static final RegistryObject<MenuType<Controlegui4Menu>> CONTROLEGUI_4 = REGISTRY.register("controlegui_4",
			() -> IForgeMenuType.create(Controlegui4Menu::new));
	public static final RegistryObject<MenuType<Controlegui5Menu>> CONTROLEGUI_5 = REGISTRY.register("controlegui_5",
			() -> IForgeMenuType.create(Controlegui5Menu::new));
	public static final RegistryObject<MenuType<ServerToolGUIMenu>> SERVER_TOOL_GUI = REGISTRY.register("server_tool_gui",
			() -> IForgeMenuType.create(ServerToolGUIMenu::new));
	public static final RegistryObject<MenuType<BusUtilitiesCMDGUIMenu>> BUS_UTILITIES_CMDGUI = REGISTRY.register("bus_utilities_cmdgui",
			() -> IForgeMenuType.create(BusUtilitiesCMDGUIMenu::new));
	public static final RegistryObject<MenuType<ServerCMDGUIMenu>> SERVER_CMDGUI = REGISTRY.register("server_cmdgui",
			() -> IForgeMenuType.create(ServerCMDGUIMenu::new));
	public static final RegistryObject<MenuType<Controlegui6Menu>> CONTROLEGUI_6 = REGISTRY.register("controlegui_6",
			() -> IForgeMenuType.create(Controlegui6Menu::new));
	public static final RegistryObject<MenuType<Controlegui7Menu>> CONTROLEGUI_7 = REGISTRY.register("controlegui_7",
			() -> IForgeMenuType.create(Controlegui7Menu::new));
	public static final RegistryObject<MenuType<Controlegui8Menu>> CONTROLEGUI_8 = REGISTRY.register("controlegui_8",
			() -> IForgeMenuType.create(Controlegui8Menu::new));
	public static final RegistryObject<MenuType<Controlegui9Menu>> CONTROLEGUI_9 = REGISTRY.register("controlegui_9",
			() -> IForgeMenuType.create(Controlegui9Menu::new));
	public static final RegistryObject<MenuType<Controlegui10Menu>> CONTROLEGUI_10 = REGISTRY.register("controlegui_10",
			() -> IForgeMenuType.create(Controlegui10Menu::new));
	public static final RegistryObject<MenuType<MaintenanceModMenu>> MAINTENANCE_MOD = REGISTRY.register("maintenance_mod",
			() -> IForgeMenuType.create(MaintenanceModMenu::new));
	public static final RegistryObject<MenuType<ShopchoixMenu>> SHOPCHOIX = REGISTRY.register("shopchoix",
			() -> IForgeMenuType.create(ShopchoixMenu::new));
	public static final RegistryObject<MenuType<BuyTicket1Menu>> BUY_TICKET_1 = REGISTRY.register("buy_ticket_1",
			() -> IForgeMenuType.create(BuyTicket1Menu::new));
	public static final RegistryObject<MenuType<BuyTicket3Menu>> BUY_TICKET_3 = REGISTRY.register("buy_ticket_3",
			() -> IForgeMenuType.create(BuyTicket3Menu::new));
	public static final RegistryObject<MenuType<BuyTicket10Menu>> BUY_TICKET_10 = REGISTRY.register("buy_ticket_10",
			() -> IForgeMenuType.create(BuyTicket10Menu::new));
	public static final RegistryObject<MenuType<CarteexistanteMenu>> CARTEEXISTANTE = REGISTRY.register("carteexistante",
			() -> IForgeMenuType.create(CarteexistanteMenu::new));
	public static final RegistryObject<MenuType<CreateCardMenu>> CREATE_CARD = REGISTRY.register("create_card",
			() -> IForgeMenuType.create(CreateCardMenu::new));
	public static final RegistryObject<MenuType<BuyCarte10Menu>> BUY_CARTE_10 = REGISTRY.register("buy_carte_10",
			() -> IForgeMenuType.create(BuyCarte10Menu::new));
	public static final RegistryObject<MenuType<BuyCarteEMenu>> BUY_CARTE_E = REGISTRY.register("buy_carte_e",
			() -> IForgeMenuType.create(BuyCarteEMenu::new));
	public static final RegistryObject<MenuType<BuyCarteIllimiteMenu>> BUY_CARTE_ILLIMITE = REGISTRY.register("buy_carte_illimite",
			() -> IForgeMenuType.create(BuyCarteIllimiteMenu::new));
	public static final RegistryObject<MenuType<MoneyGUIMenu>> MONEY_GUI = REGISTRY.register("money_gui",
			() -> IForgeMenuType.create(MoneyGUIMenu::new));
	public static final RegistryObject<MenuType<MoneyAddGUIMenu>> MONEY_ADD_GUI = REGISTRY.register("money_add_gui",
			() -> IForgeMenuType.create(MoneyAddGUIMenu::new));
	public static final RegistryObject<MenuType<MoneyRecuGUIMenu>> MONEY_RECU_GUI = REGISTRY.register("money_recu_gui",
			() -> IForgeMenuType.create(MoneyRecuGUIMenu::new));
	public static final RegistryObject<MenuType<BuyTicket1ExpressGUIMenu>> BUY_TICKET_1_EXPRESS_GUI = REGISTRY.register("buy_ticket_1_express_gui",
			() -> IForgeMenuType.create(BuyTicket1ExpressGUIMenu::new));
	public static final RegistryObject<MenuType<NewsGUIMenu>> NEWS_GUI = REGISTRY.register("news_gui", () -> IForgeMenuType.create(NewsGUIMenu::new));
	public static final RegistryObject<MenuType<StartlangMenu>> STARTLANG = REGISTRY.register("startlang",
			() -> IForgeMenuType.create(StartlangMenu::new));
	public static final RegistryObject<MenuType<StartFrMenu>> START_FR = REGISTRY.register("start_fr", () -> IForgeMenuType.create(StartFrMenu::new));
	public static final RegistryObject<MenuType<StartFr0Menu>> START_FR_0 = REGISTRY.register("start_fr_0",
			() -> IForgeMenuType.create(StartFr0Menu::new));
	public static final RegistryObject<MenuType<StartFr1Menu>> START_FR_1 = REGISTRY.register("start_fr_1",
			() -> IForgeMenuType.create(StartFr1Menu::new));
	public static final RegistryObject<MenuType<StartFr2Menu>> START_FR_2 = REGISTRY.register("start_fr_2",
			() -> IForgeMenuType.create(StartFr2Menu::new));
	public static final RegistryObject<MenuType<StartFr3Menu>> START_FR_3 = REGISTRY.register("start_fr_3",
			() -> IForgeMenuType.create(StartFr3Menu::new));
	public static final RegistryObject<MenuType<StartFr4Menu>> START_FR_4 = REGISTRY.register("start_fr_4",
			() -> IForgeMenuType.create(StartFr4Menu::new));
	public static final RegistryObject<MenuType<StartFr5Menu>> START_FR_5 = REGISTRY.register("start_fr_5",
			() -> IForgeMenuType.create(StartFr5Menu::new));
	public static final RegistryObject<MenuType<StartFr6Menu>> START_FR_6 = REGISTRY.register("start_fr_6",
			() -> IForgeMenuType.create(StartFr6Menu::new));
	public static final RegistryObject<MenuType<StartFr7Menu>> START_FR_7 = REGISTRY.register("start_fr_7",
			() -> IForgeMenuType.create(StartFr7Menu::new));
	public static final RegistryObject<MenuType<StartFr8Menu>> START_FR_8 = REGISTRY.register("start_fr_8",
			() -> IForgeMenuType.create(StartFr8Menu::new));
	public static final RegistryObject<MenuType<StartFr9Menu>> START_FR_9 = REGISTRY.register("start_fr_9",
			() -> IForgeMenuType.create(StartFr9Menu::new));
	public static final RegistryObject<MenuType<HelpMenuMenu>> HELP_MENU = REGISTRY.register("help_menu",
			() -> IForgeMenuType.create(HelpMenuMenu::new));
	public static final RegistryObject<MenuType<Ticket1VGUIMenu>> TICKET_1_VGUI = REGISTRY.register("ticket_1_vgui",
			() -> IForgeMenuType.create(Ticket1VGUIMenu::new));
	public static final RegistryObject<MenuType<Ticket3VGUIMenu>> TICKET_3_VGUI = REGISTRY.register("ticket_3_vgui",
			() -> IForgeMenuType.create(Ticket3VGUIMenu::new));
	public static final RegistryObject<MenuType<Ticket10VGUIMenu>> TICKET_10_VGUI = REGISTRY.register("ticket_10_vgui",
			() -> IForgeMenuType.create(Ticket10VGUIMenu::new));
	public static final RegistryObject<MenuType<CarteGUIMenu>> CARTE_GUI = REGISTRY.register("carte_gui",
			() -> IForgeMenuType.create(CarteGUIMenu::new));
}
