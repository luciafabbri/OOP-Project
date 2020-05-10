package tiles;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import worldModel.utilities.GameSettings;

public class DoorSouth extends AnimatedTile {

	/**
	 * Constructor for DoorEast
	 * @throws SlickException
	 * @see SlickException
	 * 
	 * {@inheritDoc}
	 */
	public DoorSouth() throws SlickException {
		super(new Animation(new SpriteSheet(new Image("./res/walls/doors/door4.png"), GameSettings.TILESIZE, GameSettings.TILESIZE), 100));
	}

}
