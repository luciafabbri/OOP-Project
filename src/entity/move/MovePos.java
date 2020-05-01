package entity.move;

import design.utilities.Pair;

/**
 * An interface used to set next entity's coordinates and direction in the dungeon 
 */

public interface MovePos {
	
	/**
	 * @param pos, entity's current coordinates 
	 * @param dir, entity's current direction
	 * @return the possible next entity's coordinates and direction
	 */
	Pair<Integer,Integer> nextPos(Pair<Integer,Integer> pos, Direction dir);

}
