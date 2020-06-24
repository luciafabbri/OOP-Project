package main.tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import main.coordination.LoadNatives;
import main.worldModel.utilities.GameSettings;

public class Corner1 extends Tile {

	/**
	 * Constructor for Corner1
	 * @throws SlickException
	 * @see SlickException
	 * 
	 * {@inheritDoc}
	 */
	public Corner1() throws SlickException {
		super(LoadNatives.loadTile(GameSettings.RESPATH + "res" + GameSettings.SEP + "walls" + GameSettings.SEP + "wall_inner_corner_1.png"));
	}

}
