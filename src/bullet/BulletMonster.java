package bullet;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import bullet.move.CheckMonsBull;
import utility.Debuff;
import utility.Direction;
import design.RoomDesign;
import design.utilities.Pair;

public class BulletMonster extends BulletImpl implements Bullet{
	
	

	public BulletMonster(Pair<Integer, Integer> position, int damage, int speed, Debuff debuff, Direction direction, RoomDesign room) {
		super(position, damage, speed, debuff, direction, room, TypeBullet.MONSTER);
		try {
			this.setTexture(new Image("./res/proj/EnemyProj.png"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BulletMonster(Pair<Integer, Integer> position, int damage, Direction direction, RoomDesign room) {
		this(position, damage, 1, Debuff.NO_ONE, direction, room);
		try {
			this.setTexture(new Image("./res/proj/EnemyProj.png"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updatePos() {
		super.updatePos(new CheckMonsBull(this));
	}

}
