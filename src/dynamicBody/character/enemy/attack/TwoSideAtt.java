package dynamicBody.character.enemy.attack;

import java.util.List;

import design.RoomDesign;
import design.utilities.Pair;
import dynamicBody.bullet.Bullet;
import dynamicBody.bullet.BulletMonsterImpl;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.move.Direction;

public class TwoSideAtt extends DistanceBullAbst implements MonsterAttack {

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
			Bullet bull = new BulletMonsterImpl(calculateBullPos(dirSpawn.get(i), enemy), dmg, bullDir.get(i), currentRoom);
			
			enemy.addBullet(bull);
		}
		
		
		
	}
	

}
