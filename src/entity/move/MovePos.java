package entity.move;

import design.utilities.Pair;

/**
 * An interface 
 */

public interface MovePos {
	
	/**
	 * @param pos, entity's current coordinates 
	 * @param dir, entity's current direction
	 * @return the possible next entity's coordinates in the dungeon
	 */
	Pair<Integer,Integer> nextPos(Pair<Integer,Integer> pos, Direction dir);

}
