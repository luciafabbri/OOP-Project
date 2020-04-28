package entity.move;

import design.RoomDesign;
import design.utilities.Pair;

/**
 * An interface 
 */

public interface CheckPos {
	
	boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos);

}
