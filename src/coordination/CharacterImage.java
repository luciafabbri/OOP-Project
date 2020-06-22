package coordination;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import worldModel.utilities.GameSettings;

public enum CharacterImage {

	FRONT_PLAYER("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "mainChar6_front.png"), 
	BACK_PLAYER("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "mainChar6_back.png"),
	LEFT_PLAYER("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "mainChar6_left.png"), 
	RIGHT_PLAYER("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "mainChar6_right.png"),

	FRONT_BOWMAN("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "Enemy1_front.png"), 
	BACK_BOWMAN("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "Enemy1_back.png"),
	LEFT_BOWMAN("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "Enemy1_left.png"), 
	RIGHT_BOWMAN("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "Enemy1_right.png"),

	FRONT_MAGE("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "Enemy3_front.png"), 
	BACK_MAGE("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "Enemy3_back.png"),
	LEFT_MAGE("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "Enemy3_left.png"), 
	RIGHT_MAGE("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "Enemy3_right.png"),

	FRONT_NINJA("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "Enemy2_front.png"), 
	BACK_NINJA("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "Enemy2_back.png"),
	LEFT_NINJA("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "Enemy2_left.png"), 
	RIGHT_NINJA("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "Enemy2_right.png"),

	PLANT("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "plan.png"),

	FRONT_BOSS("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "Boss_front.png"), 
	BACK_BOSS("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "Boss_back.png"),
	LEFT_BOSS("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "Boss_left.png"), 
	RIGHT_BOSS("." + GameSettings.SEP + "res" + GameSettings.SEP + "chars" + GameSettings.SEP + "enemies" + GameSettings.SEP + "Boss_right.png"),

	PLAYER_BULLET("." + GameSettings.SEP + "res" + GameSettings.SEP + "proj" + GameSettings.SEP + "MainProj.png"),
	
	ENEMY_BULLET("." + GameSettings.SEP + "res" + GameSettings.SEP + "proj" + GameSettings.SEP + "EnemyProj.png");
	
	String image;

	/**
	 * Default constructor
	 * 
	 * @param String, a string where you can find the spritesheet
	 */
	CharacterImage(String image) {
		this.image = image;
	}
	
	public Image getImage() throws SlickException {
		return new Image(image);
	}
}
