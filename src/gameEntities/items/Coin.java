package gameEntities.items;

import java.util.Optional;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.utilities.Pair;
import design.utilities.enums.Entities;
import design.utilities.enums.Pickupables;

public class Coin extends ItemImpl {

	public Coin(final Pair<Integer, Integer> coord) throws SlickException {
		super(coord);
		this.setTexture(new Image("./res/items/coin.png"));
	}

}
