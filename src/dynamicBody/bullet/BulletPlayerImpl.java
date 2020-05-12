package dynamicBody.bullet;

import dynamicBody.move.Direction;
import worldModel.RoomModel;
import worldModel.utilities.Pair;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Class that implements interface Bullet, used to create a bullet of type player 
 */

public class BulletPlayerImpl extends BulletImpl implements Bullet {

	/**
	 * Default constructor
	 * 
	 * @param position, bullet's position
	 * @param damage, bullet's damage power
	 * @param direction, bullet's direction
	 * @param room, bullet's current room
	 */
	public BulletPlayerImpl(Pair<Integer, Integer> position, int damage, Direction direction, RoomModel room) {
		super(position, damage, direction, room, TypeBullet.PLAYER);
		try {
			this.setTexture(new Image("./res/proj/MainProj.png"));
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}