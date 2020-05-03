package dynamicBody.character.player;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import dynamicBody.UpDownLeftRight;

/**
 * Enumeration used to set player's image based on his current direction
 */

public enum PlayerImages {
	
	FRONT("./res/chars/mainChar6_front.png"),
	BACK("./res/chars/mainChar6_back.png"),
	LEFT("./res/chars/mainChar6_left.png"),
	RIGHT("./res/chars/mainChar6_right.png");

	private String image;
	
	/**
	 * Default constructor
	 * @param image, image used to represent the player based on his direction
	 */
	PlayerImages(String image)  {
		this.image = image;
	}
	
	public static UpDownLeftRight<Animation> getTexture(PlayerImpl player) throws SlickException {
		Animation front = FRONT.getAnimation();
		Animation back = BACK.getAnimation();	
		Animation left = LEFT.getAnimation();	
		Animation right = RIGHT.getAnimation();
		return new UpDownLeftRight<>(back, front, left, right);
	}
	
	/**
	 * Method used to get player's animation from his image based on his current direction
	 * @return player's correct animation
	 * @throws SlickException
	 */
	private Animation getAnimation() throws SlickException {
		return new Animation(new SpriteSheet(new Image(image), 64, 64), 100);
	}
}
