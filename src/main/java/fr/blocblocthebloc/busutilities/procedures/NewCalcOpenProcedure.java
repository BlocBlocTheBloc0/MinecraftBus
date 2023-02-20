package fr.blocblocthebloc.busutilities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import fr.blocblocthebloc.busutilities.network.BusutilitiesModVariables;

public class NewCalcOpenProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = Mth.nextInt(RandomSource.create(), 1, 10);
			entity.getCapability(BusutilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.CalcV1 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = Mth.nextInt(RandomSource.create(), 1, 10);
			entity.getCapability(BusutilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.CalcV2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getCapability(BusutilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BusutilitiesModVariables.PlayerVariables())).CalcV1
					+ (entity.getCapability(BusutilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BusutilitiesModVariables.PlayerVariables())).CalcV2;
			entity.getCapability(BusutilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.CalcResult = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		CalcGUIOpenProcedure.execute(world, x, y, z, entity);
	}
}
