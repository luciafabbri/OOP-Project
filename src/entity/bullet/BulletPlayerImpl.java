package entity.bullet;

import design.RoomDesign;
import design.utilities.Pair;
import entity.move.Direction;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BulletPlayerImpl extends BulletImpl implements Bullet {

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