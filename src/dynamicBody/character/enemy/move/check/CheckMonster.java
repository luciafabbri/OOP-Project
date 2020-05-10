package dynamicBody.character.enemy.move.check;

import dynamicBody.move.CheckPos;
import dynamicBody.move.Direction;
import worldModel.RoomModel;
import worldModel.utilities.Pair;

public interface CheckMonster extends CheckPos {
	
	/**
	 * Methods use to change the Direction of monster
	 * @param room, RoomModel where monster is located
	 * @param pos, position of monster
	 * @param dir, direction of monster
	 * @return a new Direction 
	 */
	public Direction changeDir(RoomModel room, Pair<Integer, Integer> pos, Direction dir);

}
