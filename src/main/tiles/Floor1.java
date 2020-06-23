package main.tiles;

import java.io.InputStream;
import java.net.URL;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import main.worldModel.utilities.GameSettings;

public class Floor1 extends Tile {
	
	
	/**
	 * Constructor for Floor1
	 * @throws SlickException
	 * @see SlickException
	 * 
	 * {@inheritDoc}
	 */
	public Floor1() throws SlickException {
		super(new Image(Tile.returnURL(GameSettings.RESPATH + "res" + GameSettings.SEP + "floor" + GameSettings.SEP + "floor_1.png"), GameSettings.RESPATH + "res" + GameSettings.SEP + "floor" + GameSettings.SEP + "floor_1.png", false));
	}

}
