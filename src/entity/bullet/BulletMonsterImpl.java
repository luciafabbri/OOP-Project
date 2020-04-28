package entity.bullet;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import design.RoomDesign;
import design.utilities.Pair;
import entity.move.Direction;

public class BulletMonsterImpl extends BulletImpl implements Bullet{

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
