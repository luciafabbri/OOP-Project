package gameEntities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Enum listing the texture for each GameEntity object
 *
 */
public enum EntityImage {
	
	OBSTACLE("./res/obstacles/obstacle_stone1.png"),
	STAIRS("./res/floor/stairs.png"),
	COIN("./res/items/coin.png"),
	KEY("./res/items/key.png"),
	ATTACKSPEED1("./res/items/mod/attackMod1.png"),
	ATTACKUPGRADE1("./res/items/mod/AttackSpeedMod1.png"),
	HEALTHUPGRADE1("./res/items/mod/healthMod1.png"),
	MOVEMENTSPEED1("./res/items/mod/MovementSpeedMod1.png"),
	RECOVERHEALTH("./res/items/RecoverHealth.png");

	String image;
	
	EntityImage(String image) {
		this.image = image;
	}
	
	public Image getImage() throws SlickException {
		return new Image(image);
	}
	
}
