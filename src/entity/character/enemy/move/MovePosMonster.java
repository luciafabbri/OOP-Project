package entity.character.enemy.move;

import design.utilities.Pair;
import entity.move.Direction;

public interface MovePosMonster {
	
	public Pair<Integer,Integer> nextPos(Pair<Integer,Integer> pos, int speed, Direction dir);
	
	public Direction getDirection();

}
