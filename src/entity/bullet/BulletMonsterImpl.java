package entity.bullet;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import design.RoomDesign;
import design.utilities.Pair;
import entity.bullet.move.CheckMonsBull;
import entity.bullet.move.CheckPlayerBull;
import entity.character.Debuff;
import entity.move.Direction;
import entity.move.Speed;

public class BulletMonsterImpl extends BulletImpl implements BulletMonster{
	
	

	public BulletMonsterImpl(Pair<Integer, Integer> position, int damage, Speed speed, Debuff debuff, Direction direction, RoomDesign room) {
		super(position, damage, speed, debuff, direction, room, TypeBullet.MONSTER);
		try {
			this.setTexture(new Image("./res/proj/EnemyProj.png"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BulletMonsterImpl(Pair<Integer, Integer> position, int damage, Direction direction, RoomDesign room) {
		this(position, damage, Speed.NORMAL, Debuff.NO_ONE, direction, room);
		try {
			this.setTexture(new Image("./res/proj/EnemyProj.png"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void updatePos() {
		super.updatePos(new CheckMonsBull(this));
	}

}
