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

	FRONT_PLANT("./res/chars/enemies/plan.png"),

	
	FRONT_1("./res/chars/enemies/Enemy1_front.png"), BACK_1("./res/chars/enemies/Enemy1_back.png"),
	LEFT_1("./res/chars/enemies/Enemy1_left.png"), RIGHT_1("./res/chars/enemies/Enemy1_right.png"),
	
	
	FRONT_2("./res/chars/enemies/Enemy2_front.png"), BACK_2("./res/chars/enemies/Enemy2_back.png"),
	LEFT_2("./res/chars/enemies/Enemy2_left.png"), RIGHT_2("./res/chars/enemies/Enemy2_right.png"),
	
	
	FRONT_3("./res/chars/enemies/Enemy3_front.png"), BACK_3("./res/chars/enemies/Enemy3_back.png"),
	LEFT_3("./res/chars/enemies/Enemy3_left.png"), RIGHT_3("./res/chars/enemies/Enemy3_right.png"),
	
	
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
		case PLANT:
			front = FRONT_PLANT.getAnimation();
			back = FRONT_PLANT.getAnimation();
			left = FRONT_PLANT.getAnimation();
			right = FRONT_PLANT.getAnimation();
			break;
		case MONSTER1:
			front = FRONT_1.getAnimation();
			back = BACK_1.getAnimation();
			left = LEFT_1.getAnimation();
			right = RIGHT_1.getAnimation();
			break;
		case MONSTER2:
			front = FRONT_2.getAnimation();
			back = BACK_2.getAnimation();
			left = LEFT_2.getAnimation();
			right = RIGHT_2.getAnimation();
			break;
		case MONSTER3:
			front = FRONT_2.getAnimation();
			back = BACK_2.getAnimation();
			left = LEFT_2.getAnimation();
			right = RIGHT_2.getAnimation();
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
