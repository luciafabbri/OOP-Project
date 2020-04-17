package gameEntities.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.utilities.Pair;

public class Coin extends ItemImpl {

	public Coin(final Pair<Integer, Integer> coord) throws SlickException {
		super(new Image("./res/items/coin.png"), coord);
	}

}
