package enemy.attack;

import java.util.List;

import bullet.BulletImpl;
import bullet.BulletMonster;
import utility.Direction;
import design.utilities.Pair;

public class TwoSideAtt extends MonsterAttAbst implements MonsterAttack {

	@Override
	public void createBullets(Pair<Integer, Integer> pos, Direction dir, int dmg) {
		List<Direction> dirSpawn = Direction.getNearDistance(dir, 2);
		List<Direction> bullDir = Direction.getNearDistance(dir, 1);
		
		for(int i = 0; i < 2; i++) {
			BulletImpl bull = new BulletMonster(calculateBullPos(pos, dirSpawn.get(i)), dmg, bullDir.get(i));
		}
		
	}
	

}
