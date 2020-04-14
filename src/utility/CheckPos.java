package utility;

import design.RoomDesign;
import design.utilities.Pair;

public interface CheckPos {
	
	boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos);

}
