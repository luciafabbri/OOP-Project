package dynamicBody.character.enemy;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import dynamicBody.UpDownLeftRight;
import dynamicBody.character.enemy.creator.TypeEnemy;

/**
 * Enumeration used to set enemy's image based on his current direction
 */

public enum EnemyImage {

	FRONT_BOWMAN("./res/chars/enemies/Enemy1_front.png"), BACK_BOWMAN("./res/chars/enemies/Enemy1_back.png"),
	LEFT_BOWMAN("./res/chars/enemies/Enemy1_left.png"), RIGHT_BOWMAN("./res/chars/enemies/Enemy1_right.png"),

	FRONT_MAGE("./res/chars/enemies/Enemy2_front.png"), BACK_MAGE("./res/chars/enemies/Enemy2_back.png"),
	LEFT_MAGE("./res/chars/enemies/Enemy2_left.png"), RIGHT_MAGE("./res/chars/enemies/Enemy2_right.png"),
	
	FRONT_NINJA("./res/chars/enemies/Enemy3_front.png"), BACK_NINJA("./res/chars/enemies/Enemy3_back.png"),
	LEFT_NINJA("./res/chars/enemies/Enemy3_left.png"), RIGHT_NINJA("./res/chars/enemies/Enemy3_right.png"),
	
	PLANT("./res/chars/enemies/plan.png"),

	FRONT_BOSS("./res/chars/enemies/mainChar6_front.png"), BACK_BOSS("./res/chars/enemies/mainChar6_back.png"),
	LEFT_BOSS("./res/chars/enemies/mainChar6_left.png"), RIGHT_BOSS("./res/chars/enemies/mainChar6_right.png");

	String image;

	/**
	 * Default constructor
	 * 
	 * @param String, a string where you can find the .png
	 */
	EnemyImage(String image) {
		this.image = image;
	}

	public Animation getAnimation() throws SlickException {
		return new Animation(new SpriteSheet(new Image(image), 64, 64), 100);
	}

	/**
	 * Method use to get the Animations of a monster
	 * 
	 * @param mon, the TypeMonster of the enemy
	 * @return and UpDownLeftRight with animations of the TypeEnemy
	 */
	public static UpDownLeftRight<Animation> getTexture(TypeEnemy mon) throws SlickException {
		Animation front, back, left, right;
		switch (mon) {
		case BOWMAN:
			front = FRONT_BOWMAN.getAnimation();
			back = BACK_BOWMAN.getAnimation();
			left = LEFT_BOWMAN.getAnimation();
			right = RIGHT_BOWMAN.getAnimation();
			break;
		case MAGE:
			front = FRONT_MAGE.getAnimation();
			back = BACK_MAGE.getAnimation();
			left = LEFT_MAGE.getAnimation();
			right = RIGHT_MAGE.getAnimation();
			break;
		case NINJA:
			front = FRONT_NINJA.getAnimation();
			back = BACK_NINJA.getAnimation();
			left = LEFT_NINJA.getAnimation();
			right = RIGHT_NINJA.getAnimation();
			break;
		case PLANT:
			front = PLANT.getAnimation();
			back = PLANT.getAnimation();
			left = PLANT.getAnimation();
			right = PLANT.getAnimation();
			break;
		case BOSS:
			front = FRONT_BOSS.getAnimation();
			back = BACK_BOSS.getAnimation();
			left = LEFT_BOSS.getAnimation();
			right = RIGHT_BOSS.getAnimation();
			break;

		default:
			throw new IllegalArgumentException();
		}
		return new UpDownLeftRight<>(back, front, left, right);
	}

}
