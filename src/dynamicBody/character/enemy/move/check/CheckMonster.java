package dynamicBody.character.enemy.move.check;

import design.RoomDesign;
import design.utilities.Pair;
import dynamicBody.move.CheckPos;
import dynamicBody.move.Direction;

public interface CheckMonster extends CheckPos {
	
	public Direction changeDir(RoomDesign room, Pair<Integer, Integer> pos, Direction dir);

}
