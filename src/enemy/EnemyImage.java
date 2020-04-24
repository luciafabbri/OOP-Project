package enemy;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import utility.UpDownLeftRight;

public enum EnemyImage {

	FRONT_1("./res/chars/mainChar6_back.png"),
	BACK_1("./res/chars/mainChar6_back.png"),
	LEFT_1("./res/chars/mainChar6_left.png"),
	RIGHT_1("./res/chars/mainChar6_right.png");


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
			case MONSTER1:
			case MONSTER2:
			case MONSTER3:
			case PLANT:
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
