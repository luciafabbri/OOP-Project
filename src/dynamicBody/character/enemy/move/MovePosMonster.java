package dynamicBody.character.enemy.move;

import design.utilities.Pair;
import dynamicBody.move.Direction;

public interface MovePosMonster {
	
	public Pair<Integer,Integer> nextPos(Pair<Integer,Integer> pos, int speed, Direction dir);
	
	public Direction getDirection();

}
