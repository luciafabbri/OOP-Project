package dynamicBody.character.enemy.attack;

import design.utilities.Pair;
import dynamicBody.move.Direction;

public interface MonsterAttack {
	
	public final static int DISTANCESPAWN = 10;
	
	public void createBullets(Pair<Integer,Integer> pos, Direction dir, int dmg);
	
}
