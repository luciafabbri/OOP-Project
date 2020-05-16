package gameEntities;

import worldModel.utilities.Pair;
import worldModel.utilities.enums.Entities;

/**
 * Class that models the Stairs game entity. The player cannot surpass this
 * entity, when they walk into it, they will be transported to the next level
 *
 */
public class Stairs extends Insurmountable {

	public Stairs(final Pair<Integer, Integer> position) {
		super(position, Entities.STAIR);
	}

}
