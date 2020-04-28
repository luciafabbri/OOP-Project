package entity.character.enemy.move.check;

import design.RoomDesign;
import design.utilities.Pair;
import entity.move.CheckPos;
import entity.move.Direction;

public interface CheckMonster extends CheckPos {
	
	public Direction changeDir(RoomDesign room, Pair<Integer, Integer> pos, Direction dir);

}
