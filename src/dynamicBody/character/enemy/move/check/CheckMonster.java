package dynamicBody.character.enemy.move.check;

import design.RoomDesign;
import design.utilities.Pair;
import dynamicBody.move.CheckPos;
import dynamicBody.move.Direction;

public interface CheckMonster extends CheckPos {
	
	/**
	 * Methods use to change the Direction of monster
	 * @param room, RoomDesign where monster is located
	 * @param pos, position of monster
	 * @param dir, direction of monster
	 * @return a new Direction 
	 */
	public Direction changeDir(RoomDesign room, Pair<Integer, Integer> pos, Direction dir);

}
