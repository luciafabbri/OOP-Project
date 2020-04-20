package bullet.move;

import utility.CheckPos;
import utility.Direction;
import design.utilities.Pair;

public interface MoveBull {
	
	public Pair<Integer,Integer> nextPos(Pair<Integer,Integer> pos, Direction dir, CheckPos check, int speed);
	
	public boolean isAlive();

}
