package gameEntities;

import worldModel.utilities.Pair;
import worldModel.utilities.enums.Entities;

/**
 * Class defining the pickupable entities, those that the player can pick up
 *
 */
public class Pickupable extends GameEntity {

	public Pickupable(final Pair<Integer, Integer> position, final Entities typeEnt) {
		super(position, typeEnt);
	}

}
