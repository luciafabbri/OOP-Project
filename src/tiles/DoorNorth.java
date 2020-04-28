package tiles;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import design.utilities.GameSettings;

public class DoorNorth extends AnimatedTile {

	public DoorNorth() throws SlickException {
		super(new Animation(new SpriteSheet(new Image("./res/walls/doors/door2.png"), GameSettings.TILESIZE, GameSettings.TILESIZE), 100));
	}

}
