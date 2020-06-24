package main.tiles;

import org.newdawn.slick.SlickException;

import main.coordination.init.LoadNatives;
import main.worldModel.utilities.GameSettings;

public class WallVert1 extends Tile {
	
	/**
	 * Constructor for WallVert1
	 * @throws SlickException
	 * @see SlickException
	 * 
	 * {@inheritDoc}
	 */
	public WallVert1() throws SlickException {
		super(LoadNatives.loadTile(GameSettings.RESPATH + "res" + GameSettings.SEP + "walls" + GameSettings.SEP + "wall_inner_left_1.png"));
	}
}
