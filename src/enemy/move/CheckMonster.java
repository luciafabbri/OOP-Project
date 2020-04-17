package enemy.move;

import design.RoomDesign;
import design.utilities.Pair;
import utility.CheckPos;
import utility.Direction;

public interface CheckMonster extends CheckPos {
	
	public Direction changeDir(RoomDesign room, Pair<Integer, Integer> pos, Direction dir);

}
