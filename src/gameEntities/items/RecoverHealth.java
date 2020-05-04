package gameEntities.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.utilities.Pair;
import design.utilities.enums.Entities;

public class RecoverHealth extends ItemImpl {

	/**
	 * Constructor for RecoverHealth item
	 * @param coord, to know in which position it is
	 * @throws SlickException
	 * @see SlickException
	 */
	public RecoverHealth(final Pair<Integer, Integer> coord) throws SlickException {
		super(coord, new Image("./res/items/RecoverHealth.png"), Entities.RECOVERHEALTH);
	}

}
