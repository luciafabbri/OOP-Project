package utility;

import design.RoomDesign;
import design.utilities.Pair;

public interface CheckPosDir extends CheckPos {
	
	public Direction changeDir(RoomDesign room, Pair<Integer, Integer> pos, Direction dir);

}
