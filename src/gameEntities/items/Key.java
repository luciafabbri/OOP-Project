package gameEntities.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.utilities.Pair;
import design.utilities.enums.Entities;

public class Key extends ItemImpl{
	
	public Key(final Pair<Integer, Integer> coord) throws SlickException {
		super(coord, new Image("./res/items/key.png"), Entities.KEY);
	}

}
