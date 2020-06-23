package main.gameEntities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import main.worldModel.utilities.enums.Entities;
import main.worldModel.utilities.GameSettings;

/**
 * Enum listing the texture for each GameEntity object
 *
 */
public enum EntityImage {
	
	OBSTACLE(GameSettings.RESPATH + "res" + GameSettings.SEP + "obstacles" + GameSettings.SEP + "obstacle_stone1.png", Entities.BOULDER),
	STAIRS(GameSettings.RESPATH + "res" + GameSettings.SEP + "floor" + GameSettings.SEP + "stairs.png", Entities.STAIR),
	COIN(GameSettings.RESPATH + "res" + GameSettings.SEP + "items" + GameSettings.SEP + "coin.png", Entities.COIN),
	KEY(GameSettings.RESPATH + "res" + GameSettings.SEP + "items" + GameSettings.SEP + "key.png", Entities.KEY),
	ATTACKSPEED1(GameSettings.RESPATH + "res" + GameSettings.SEP + "items" + GameSettings.SEP + "mod" + GameSettings.SEP + "attackMod1.png", Entities.ATTACKSPEED1),
	ATTACKUPGRADE1(GameSettings.RESPATH + "res" + GameSettings.SEP + "items" + GameSettings.SEP + "mod" + GameSettings.SEP + "AttackSpeedMod1.png", Entities.ATTACKUPGRADE1),
	HEALTHUPGRADE1(GameSettings.RESPATH + "res" + GameSettings.SEP + "items" + GameSettings.SEP + "mod" + GameSettings.SEP + "healthMod1.png", Entities.HEALTHUPGRADE1),
	MOVEMENTSPEED1(GameSettings.RESPATH + "res" + GameSettings.SEP + "items" + GameSettings.SEP + "mod" + GameSettings.SEP + "MovementSpeedMod1.png", Entities.MOVEMENTSPEED1),
	RECOVERHEALTH(GameSettings.RESPATH + "res" + GameSettings.SEP + "items" + GameSettings.SEP + "RecoverHealth.png", Entities.RECOVERHEALTH),
	UICOIN(GameSettings.RESPATH + "res" + GameSettings.SEP + "UI" + GameSettings.SEP + "CoinUI.png", Entities.UICOIN);
	
	String image;
	Entities entity;
	
	EntityImage(String image, Entities entity) {
		this.image = image;
		this.entity = entity;
	}
	
	public Image getImage() throws SlickException {
		try {
			return new Image(new URL("file:///" + image).openStream(), image, false);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Entities getEntity() {
		return entity;
	}
	
}
