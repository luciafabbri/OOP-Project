package main.gameEntities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import main.worldModel.utilities.enums.Entities;

/**
 * Enum listing the texture for each GameEntity object
 *
 */
public enum EntityImage {
	
	OBSTACLE("./res/obstacles/obstacle_stone1.png", Entities.BOULDER),
	STAIRS("./res/floor/stairs.png", Entities.STAIR),
	COIN("./res/items/coin.png", Entities.COIN),
	KEY("./res/items/key.png", Entities.KEY),
	ATTACKSPEED1("./res/items/mod/attackMod1.png", Entities.ATTACKSPEED1),
	ATTACKUPGRADE1("./res/items/mod/AttackSpeedMod1.png", Entities.ATTACKUPGRADE1),
	HEALTHUPGRADE1("./res/items/mod/healthMod1.png", Entities.HEALTHUPGRADE1),
	MOVEMENTSPEED1("./res/items/mod/MovementSpeedMod1.png", Entities.MOVEMENTSPEED1),
	RECOVERHEALTH("./res/items/RecoverHealth.png", Entities.RECOVERHEALTH);

	String image;
	Entities entity;
	
	EntityImage(String image, Entities entity) {
		this.image = image;
		this.entity = entity;
	}
	
	public Image getImage() throws SlickException {
		return new Image(image);
	}

	public Entities getEntity() {
		return entity;
	}
	
}
