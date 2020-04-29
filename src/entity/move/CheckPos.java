package entity.move;

import design.RoomDesign;
import design.utilities.Pair;

/**
 * An interface 
 */

public interface CheckPos {
	
	/**
	 * @param room, entity's current room
	 * @param pos, entity's current coordinates 
	 * @return
	 */
	boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos);

}
