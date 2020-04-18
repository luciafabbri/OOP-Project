package gameEntities.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.utilities.Entities;
import design.utilities.Pair;

public class Key extends ItemImpl{
	
	public Key(final Pair<Integer, Integer> coord) throws SlickException {
		super(coord, Entities.KEY);
		this.setTexture(new Image("./res/items/key.png"));
}

}
