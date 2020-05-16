package gameEntities.items;

import worldModel.utilities.Pair;
import worldModel.utilities.enums.Entities;

public class Coin extends ItemImpl {

	/**
	 * Constructor for Coin item
	 * @param coord, to know in which position it is
	 * @throws SlickException
	 * @see SlickException
	 */
	public Coin(final Pair<Integer, Integer> coord) {
		super(coord, Entities.COIN);
	}

}
