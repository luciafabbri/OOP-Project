package main.tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class WallHor1 extends Tile {

	/**
	 * Constructor for WallHor1
	 * @throws SlickException
	 * @see SlickException
	 * 
	 * {@inheritDoc}
	 */
	public WallHor1() throws SlickException {
		super(new Image("./res/walls/wall_inner_down_1.png"));
	}
}
