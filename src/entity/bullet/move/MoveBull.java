package entity.bullet.move;

import design.utilities.Pair;
import entity.move.CheckPos;
import entity.move.Direction;

/**
 * An interface used to move bullet's position in the dungeon
 */

public interface MoveBull {
	
	/**
	 * @param pos, 
	 * @param dir, 
	 * @param check, type of bullet's check
	 * @return the possible next bullet's position in the dungeon
	 */
	public Pair<Integer,Integer> nextPos(Pair<Integer,Integer> pos, Direction dir, CheckPos check);
	
	/**
	 * @return true if the bullet is alive
	 */
	public boolean isAlive();

}
