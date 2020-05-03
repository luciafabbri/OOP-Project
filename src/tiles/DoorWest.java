package tiles;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import design.utilities.GameSettings;

public class DoorWest extends AnimatedTile {

	/**
	 * Constructor for DoorEast
	 * @throws SlickException
	 * @see SlickException
	 * 
	 * {@inheritDoc}
	 */
	public DoorWest() throws SlickException {
		super(new Animation(new SpriteSheet(new Image("./res/walls/doors/door1.png"), GameSettings.TILESIZE, GameSettings.TILESIZE), 100));
	}

}
