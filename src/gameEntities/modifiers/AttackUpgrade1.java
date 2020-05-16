package gameEntities.modifiers;

import dynamicBody.character.Stats;
import worldModel.utilities.Pair;
import worldModel.utilities.enums.Entities;

public class AttackUpgrade1 extends ModifiersImpl{

	public AttackUpgrade1(Pair<Integer, Integer> coord) {
		super(coord, Stats.ATTACK, 10, "Ebony Bow", Entities.ATTACKUPGRADE1);
	}
}
