package enemy.attack;

import utility.Direction;
import design.utilities.Pair;

public interface MonsterAttack {
	
	public final static int DISTANCESPAWN = 10;
	
	public void createBullets(Pair<Integer,Integer> pos, Direction dir, int dmg);
	
}
