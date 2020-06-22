package main.tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Corner1 extends Tile {

	/**
	 * Constructor for Corner1
	 * @throws SlickException
	 * @see SlickException
	 * 
	 * {@inheritDoc}
	 */
	public Corner1() throws SlickException {
		super(new Image("./res/walls/wall_inner_corner_1.png"));
	}

}
