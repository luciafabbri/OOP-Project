package coordination;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import dynamicBody.UpDownLeftRight;
import dynamicBody.character.enemy.creator.TypeEnemy;
import dynamicBody.move.Direction;

public class ImageFactory {
	
	
	private static UpDownLeftRight<Image> getEnemyImages(TypeEnemy mon) throws SlickException {
		Image front, back, left, right;
		switch (mon) {		
		case BOWMAN:
			front = CharacterImage.FRONT_BOWMAN.getImage();
			back = CharacterImage.BACK_BOWMAN.getImage();
			left = CharacterImage.LEFT_BOWMAN.getImage();
			right = CharacterImage.RIGHT_BOWMAN.getImage();
			break;
		case MAGE:
			front = CharacterImage.FRONT_MAGE.getImage();
			back = CharacterImage.BACK_MAGE.getImage();
			left = CharacterImage.LEFT_MAGE.getImage();
			right = CharacterImage.RIGHT_MAGE.getImage();
			break;
		case NINJA:
			front = CharacterImage.FRONT_NINJA.getImage();
			back = CharacterImage.BACK_NINJA.getImage();
			left = CharacterImage.LEFT_NINJA.getImage();
			right = CharacterImage.RIGHT_NINJA.getImage();
			break;
		case PLANT:
			front = CharacterImage.PLANT.getImage();
			back = CharacterImage.PLANT.getImage();
			left = CharacterImage.PLANT.getImage();
			right = CharacterImage.PLANT.getImage();
			break;
		case BOSS:
			front = CharacterImage.FRONT_BOSS.getImage();
			back = CharacterImage.BACK_BOSS.getImage();
			left = CharacterImage.LEFT_BOSS.getImage();
			right = CharacterImage.RIGHT_BOSS.getImage();
			break;
		default:
			throw new IllegalArgumentException("Type of Dynamic Body not found");
		}
		return new UpDownLeftRight<>(back, front, left, right);
	}
	public static Image getEnemyImage(TypeEnemy type, Direction dir) throws SlickException {
		UpDownLeftRight<Image> enemyImages = getEnemyImages(type);
		switch (dir) {
		case NORTH:
			return enemyImages.getUp();
		case SOUTH:
			return enemyImages.getDown();
		case WEST:
			return enemyImages.getLeft();
		case EAST:
			return enemyImages.getRight();
		default:
			throw new IllegalArgumentException("The Animation of the Direction isn't implemented");
		}
	}
	
	public static Animation getAnimation(Image image) {
		return new Animation(new SpriteSheet(image, 64, 64), 100);
	}
	
	public static Image getPlayerBull() throws SlickException {
		return CharacterImage.PLAYER_BULLET.getImage();
	}
	
	public static Image getEnemyBull() throws SlickException {
		return CharacterImage.ENEMY_BULLET.getImage();
	}

	public static Image getPlayerImage(Direction dir) throws SlickException {
		switch (dir) {
		case NORTH:
			return CharacterImage.BACK_PLAYER.getImage();
		case SOUTH:
			return CharacterImage.FRONT_PLAYER.getImage();
		case WEST:
			return CharacterImage.LEFT_PLAYER.getImage();
		case EAST:
			return CharacterImage.RIGHT_PLAYER.getImage();
		default:
			throw new IllegalArgumentException("The Animation of the Direction isn't implemented");
		}
	}
}
