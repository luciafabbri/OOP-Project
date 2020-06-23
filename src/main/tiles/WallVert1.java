package main.tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

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
		super(new Image(Tile.returnURL(GameSettings.RESPATH + "res" + GameSettings.SEP + "walls" + GameSettings.SEP + "wall_inner_left_1.png"), GameSettings.RESPATH + "res" + GameSettings.SEP + "walls" + GameSettings.SEP + "wall_inner_left_1.png", false));
	}
}
