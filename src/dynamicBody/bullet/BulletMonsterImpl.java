package dynamicBody.bullet;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import design.RoomDesign;
import design.utilities.Pair;
import dynamicBody.move.Direction;

public class BulletMonsterImpl extends BulletImpl implements Bullet{

	/**
	 * Default constructor
	 * @param position, bullet's position
	 * @param damage, bullet's damage power
	 * @param direction, bullet's direction
	 * @param room, bullet's current room
	 */
	public BulletMonsterImpl(Pair<Integer, Integer> position, int damage, Direction direction, RoomDesign room) {
		super(position, damage, direction, room, TypeBullet.MONSTER);
		try {
			this.setTexture(new Image("./res/proj/EnemyProj.png"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
