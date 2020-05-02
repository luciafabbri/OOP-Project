package entity.move;

import design.RoomDesign;
import design.utilities.Pair;

/**
 * An interface used to check if entity's next position is going to be in a possible free space in the dungeon or not
 */

public interface CheckPos {
	
	/**
	 * Based on entity's current coordinates, this method checks if the next ones are not occupied 
	 * by any other object in the dungeon
	 * @param room, entity's current room
	 * @param pos, entity's current coordinates 
	 * @return true if the entity could move in its next position
	 */
	boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos);

}
