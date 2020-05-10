package gameEntities.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import worldModel.utilities.Pair;
import worldModel.utilities.enums.Entities;

public class Coin extends ItemImpl {

	/**
	 * Constructor for Coin item
	 * @param coord, to know in which position it is
	 * @throws SlickException
	 * @see SlickException
	 */
	public Coin(final Pair<Integer, Integer> coord) throws SlickException {
		super(coord, new Image("./res/items/coin.png"), Entities.COIN);
	}

}
