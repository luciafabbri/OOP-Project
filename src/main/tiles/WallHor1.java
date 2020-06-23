package main.tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

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
		super(new Image(Tile.returnURL(GameSettings.RESPATH + "res" + GameSettings.SEP + "walls" + GameSettings.SEP + "wall_inner_down_1.png"), GameSettings.RESPATH + "res" + GameSettings.SEP + "walls" + GameSettings.SEP + "wall_inner_down_1.png", false));
	}
}
