package main.tiles;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import main.coordination.LoadNatives;
import main.worldModel.utilities.GameSettings;

public class DoorNorth extends AnimatedTile {

	/**
	 * Constructor for DoorEast
	 * @throws SlickException
	 * @see SlickException
	 * 
	 * {@inheritDoc}
	 */
	public DoorNorth() throws SlickException {
		super(new Animation
				(new SpriteSheet
						(LoadNatives.loadTile(GameSettings.RESPATH + "res" + GameSettings.SEP + "walls" + GameSettings.SEP + "doors" + GameSettings.SEP + "door2.png"), GameSettings.TILESIZE, GameSettings.TILESIZE), 100));
	}

}
