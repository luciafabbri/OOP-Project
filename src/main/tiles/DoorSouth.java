package main.tiles;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import main.worldModel.utilities.GameSettings;

public class DoorSouth extends AnimatedTile {

	/**
	 * Constructor for DoorEast
	 * @throws SlickException
	 * @see SlickException
	 * 
	 * {@inheritDoc}
	 */
	public DoorSouth() throws SlickException {
		super(new Animation
				(new SpriteSheet
						(new Image(Tile.returnURL(GameSettings.RESPATH + "res" + GameSettings.SEP + "walls" + GameSettings.SEP + "doors" + GameSettings.SEP + "door4.png"), GameSettings.RESPATH + "res" + GameSettings.SEP + "walls" + GameSettings.SEP + "doors" + GameSettings.SEP + "door4.png", false), GameSettings.TILESIZE, GameSettings.TILESIZE), 100));
	}

}
