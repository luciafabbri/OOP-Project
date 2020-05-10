package gameEntities.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import worldModel.utilities.Pair;
import worldModel.utilities.enums.Entities;

public class Key extends ItemImpl{
	
	/**
	 * Constructor for Key item
	 * @param coord, to know in which position it is
	 * @throws SlickException
	 * @see SlickException
	 */
	public Key(final Pair<Integer, Integer> coord) throws SlickException {
		super(coord, new Image("./res/items/key.png"), Entities.KEY);
	}

}
