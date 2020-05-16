package gameEntities.modifiers;

import gameEntities.items.ItemImpl;
import worldModel.utilities.Pair;
import worldModel.utilities.enums.Entities;

public class RecoverHealth extends ItemImpl {

	/**
	 * Constructor for RecoverHealth item
	 * @param coord, to know in which position it is
	 * @throws SlickException
	 * @see SlickException
	 */
	public RecoverHealth(final Pair<Integer, Integer> coord) {
		super(coord, Entities.RECOVERHEALTH);
	}

}
