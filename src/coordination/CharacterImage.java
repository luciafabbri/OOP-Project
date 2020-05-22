package coordination;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public enum CharacterImage {

	FRONT_PLAYER("./res/chars/mainChar6_front.png"), BACK_PLAYER("./res/chars/mainChar6_back.png"),
	LEFT_PLAYER("./res/chars/mainChar6_left.png"), RIGHT_PLAYER("./res/chars/mainChar6_right.png"),

	FRONT_BOWMAN("./res/chars/enemies/Enemy1_front.png"), BACK_BOWMAN("./res/chars/enemies/Enemy1_back.png"),
	LEFT_BOWMAN("./res/chars/enemies/Enemy1_left.png"), RIGHT_BOWMAN("./res/chars/enemies/Enemy1_right.png"),

	FRONT_MAGE("./res/chars/enemies/Enemy3_front.png"), BACK_MAGE("./res/chars/enemies/Enemy3_back.png"),
	LEFT_MAGE("./res/chars/enemies/Enemy3_left.png"), RIGHT_MAGE("./res/chars/enemies/Enemy3_right.png"),

	FRONT_NINJA("./res/chars/enemies/Enemy2_front.png"), BACK_NINJA("./res/chars/enemies/Enemy2_back.png"),
	LEFT_NINJA("./res/chars/enemies/Enemy2_left.png"), RIGHT_NINJA("./res/chars/enemies/Enemy2_right.png"),

	PLANT("./res/chars/enemies/plan.png"),

	FRONT_BOSS("./res/chars/enemies/Boss_front.png"), BACK_BOSS("./res/chars/enemies/Boss_back.png"),
	LEFT_BOSS("./res/charsz/enemies/Boss_left.png"), RIGHT_BOSS("./res/chars/enemies/Boss_right.png"),

	PLAYER_BULLET("./res/proj/MainProj.png"),
	
	ENEMY_BULLET("./res/proj/EnemyProj.png");
	
	String image;

	/**
	 * Default constructor
	 * 
	 * @param String, a string where you can find the .png
	 */
	CharacterImage(String image) {
		this.image = image;
	}
	
	public Image getImage() throws SlickException {
		return new Image(image);
	}
}
