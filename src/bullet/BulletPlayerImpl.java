package bullet;

import utility.Debuff;
import utility.Direction;
import design.RoomDesign;
import design.utilities.Pair;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import bullet.move.CheckPlayerBull;

public class BulletPlayerImpl extends BulletImpl implements BulletPlayer {

	public BulletPlayerImpl(Pair<Integer, Integer> position, int damage, int speed, Debuff debuff, Direction direction, RoomDesign room) {
		super(position, damage, speed, debuff, direction, room, TypeBullet.PLAYER);
		try {
			this.setTexture(new Image("./res/proj/MainProj.png"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BulletPlayerImpl(Pair<Integer, Integer> position, int damage, int speed, Direction direction, RoomDesign room) {
		this(position, damage, speed, Debuff.NO_ONE, direction, room);
	}
	
	public void updatePos() {
		super.updatePos(new CheckPlayerBull(this));
	}

}