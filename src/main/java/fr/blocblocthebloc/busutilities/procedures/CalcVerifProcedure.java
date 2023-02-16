package fr.blocblocthebloc.busutilities.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import fr.blocblocthebloc.busutilities.network.BusutilitiesModVariables;

public class CalcVerifProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if ((entity.getCapability(BusutilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BusutilitiesModVariables.PlayerVariables())).CalcResult == new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:Resultat") ? ((EditBox) guistate.get("text:Resultat")).getValue() : "")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.EMERALD);
				_setstack.setCount(3);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			NewCalcProcedure.execute(entity);
			CalcGUIOpenProcedure.execute(world, x, y, z, entity);
		} else if ((entity.getCapability(BusutilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BusutilitiesModVariables.PlayerVariables())).CalcResult != new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:Resultat") ? ((EditBox) guistate.get("text:Resultat")).getValue() : "")) {
			CalcGUIOpenProcedure.execute(world, x, y, z, entity);
		}
	}
}
