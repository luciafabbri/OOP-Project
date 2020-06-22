package main.tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Floor1 extends Tile {
	
	/**
	 * Constructor for Floor1
	 * @throws SlickException
	 * @see SlickException
	 * 
	 * {@inheritDoc}
	 */
	public Floor1() throws SlickException {
		super(new Image("./res/floor/floor_1.png"));
	}

}
