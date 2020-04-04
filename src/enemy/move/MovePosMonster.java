package enemy.move;

import utility.Direction;
import utility.Pair;

public interface MovePosMonster {
	
	public Pair<Integer,Integer> nextPos(Pair<Integer,Integer> pos, Direction dir);
	
	public Direction getDirection();

}
