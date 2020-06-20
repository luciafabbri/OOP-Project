package gameEntities.modifiers;

import dynamicBody.character.player.Stats;
import worldModel.utilities.Pair;
import worldModel.utilities.enums.Entities;

public class AttackSpeed1 extends ModifiersImpl{

	public AttackSpeed1(Pair<Integer, Integer> coord) {
		super(coord, Stats.PROJ_SPEED, 15, "ROF Upgrade", Entities.ATTACKSPEED1);
	}
}
