package entity.character.enemy;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import entity.UpDownLeftRight;

public enum EnemyImage {

	FRONT_1("./res/chars/mainChar6_front.png"),
	BACK_1("./res/chars/mainChar6_back.png"),
	LEFT_1("./res/chars/mainChar6_left.png"),
	RIGHT_1("./res/chars/mainChar6_right.png"),

	FRONT_2("./res/chars/enemies/plan.png");


	String image;
	
	EnemyImage(String image)  {
		this.image = image;
	}
	
	public Animation getAnimation() throws SlickException {
		return new Animation(new SpriteSheet(new Image(image), 64, 64), 100);
	}
	
	public static UpDownLeftRight<Animation> getTexture(TypeEnemy mon) throws SlickException {
		Animation front, back, left, right;
		switch (mon) {
			case PLANT:
				front = FRONT_2.getAnimation();
				back = FRONT_2.getAnimation();
				left = FRONT_2.getAnimation();
				right = FRONT_2.getAnimation();
				break;
			case MONSTER1:
			case MONSTER2:
			case MONSTER3:
			case BOSS:
				front = FRONT_1.getAnimation();	
				back = BACK_1.getAnimation();	
				left = LEFT_1.getAnimation();	
				right = RIGHT_1.getAnimation();	
				break;
	
			default:
				throw new IllegalArgumentException();
		}
		return new UpDownLeftRight<>(back, front, left, right);
	}

}
