package main.tiles;

import org.newdawn.slick.SlickException;

import main.coordination.init.LoadNatives;
import main.worldModel.utilities.GameSettings;

public class Floor1 extends Tile {
	
	
	/**
	 * Constructor for Floor1
	 * @throws SlickException
	 * @see SlickException
	 * .
	 * {@inheritDoc}
	 */
	public Floor1() throws SlickException {
		super(LoadNatives.loadTile(GameSettings.RESPATH + "res" + GameSettings.SEP + "floor" + GameSettings.SEP + "floor_1.png"));
	}

}
