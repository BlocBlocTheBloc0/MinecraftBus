package fr.blocblocthebloc.busutilities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class VerifProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		VerifTicket1Procedure.execute(world, entity);
	}
}
