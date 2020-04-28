package entity.character.enemy.attack;

import java.util.List;

import design.RoomDesign;
import design.utilities.Pair;
import entity.bullet.Bullet;
import entity.bullet.BulletMonster;
import entity.bullet.BulletMonsterImpl;
import entity.character.enemy.Enemy;
import entity.move.Direction;

public class TwoSideAtt extends MonsterAttAbst implements MonsterAttack {

	private RoomDesign currentRoom;
	private Enemy enemy;
	
	public TwoSideAtt(RoomDesign room, Enemy enemy) {
		currentRoom = room;
		this.enemy = enemy;
	}
	
	@Override
	public void createBullets(Pair<Integer, Integer> pos, Direction dir, int dmg) {
		List<Direction> dirSpawn = Direction.getNearDistance(dir, 2);
		List<Direction> bullDir = Direction.getNearDistance(dir, 1);
		
		for(int i = 0; i < 2; i++) {
			BulletMonster bull = new BulletMonsterImpl(calculateBullPos(pos, dirSpawn.get(i), enemy), dmg, bullDir.get(i), currentRoom);
			
			enemy.addBullet(bull);
		}
		
		
		
	}
	

}
