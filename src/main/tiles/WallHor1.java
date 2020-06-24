package main.tiles;

import org.newdawn.slick.SlickException;

import main.coordination.init.LoadNatives;
import main.worldModel.utilities.GameSettings;

public class WallHor1 extends Tile {

	/**
	 * Constructor for WallHor1
	 * @throws SlickException
	 * @see SlickException
	 * 
	 * {@inheritDoc}
	 */
	public WallHor1() throws SlickException {
		super(LoadNatives.loadTile(GameSettings.RESPATH + "res" + GameSettings.SEP + "walls" + GameSettings.SEP + "wall_inner_down_1.png"));
	}
}
