package entity.move;

import design.RoomDesign;
import design.utilities.Pair;

/**
 * Interface
 */

public interface CheckPos {
	
	boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos);

}
