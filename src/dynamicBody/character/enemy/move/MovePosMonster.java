package dynamicBody.character.enemy.move;

import dynamicBody.move.Direction;
import worldModel.utilities.Pair;

/**
 * Interface use to move enemy
 */
public interface MovePosMonster {

	/**
	 * Method use to get the next position of enemy
	 * 
	 * @param pos,   Position of enemy
	 * @param speed, speed of enemy
	 * @param dir,   direction of enemy
	 * @return a Pair with next enemy's coordination
	 */
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, int speed, Direction dir);

	/**
	 * Method use to get the new direction of monster
	 * 
	 * @return the new Direction
	 */
	public Direction getDirection();

}
