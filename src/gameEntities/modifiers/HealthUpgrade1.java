package gameEntities.modifiers;


import dynamicBody.character.Stats;
import worldModel.utilities.Pair;
import worldModel.utilities.enums.Entities;

public class HealthUpgrade1 extends ModifiersImpl{

	public HealthUpgrade1(Pair<Integer, Integer> coord) {
		super(coord, Stats.HEALTH, 10, "Health Upgrade", Entities.HEALTHUPGRADE1);
	}
}
