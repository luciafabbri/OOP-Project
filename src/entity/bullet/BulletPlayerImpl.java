package entity.bullet;

import design.RoomDesign;
import design.utilities.Pair;
import entity.move.Direction;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Class that implements interface Bullet, used to create a bullet of type player 
 */

public class BulletPlayerImpl extends BulletImpl implements Bullet {

	/**
	 * Default constructor
	 * @param position, bullet's position
	 * @param damage, bullet's damage power
	 * @param direction, bullet's direction
	 * @param room, bullet's current room
	 */
	public BulletPlayerImpl(Pair<Integer, Integer> position, int damage, Direction direction, RoomDesign room) {
		super(position, damage, direction, room, TypeBullet.PLAYER);
		try {
			this.setTexture(new Image("./res/proj/MainProj.png"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}