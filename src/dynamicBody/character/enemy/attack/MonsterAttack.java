package dynamicBody.character.enemy.attack;

import design.utilities.Pair;
import dynamicBody.move.Direction;

public interface MonsterAttack {
	
	/**
	 * Method use to createBullets
	 * @param pos, position where to spawn bullets
	 * @param dir, Direction of bullets
	 * @param dmg, damage that bullets do
	 */
	public void createBullets(Pair<Integer,Integer> pos, Direction dir, int dmg);
	
}
