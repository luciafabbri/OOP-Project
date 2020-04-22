package enemy.move;

import utility.Direction;
import design.utilities.Pair;

public interface MovePosMonster {
	
	public Pair<Integer,Integer> nextPos(Pair<Integer,Integer> pos, int speed, Direction dir);
	
	public Direction getDirection();

}
