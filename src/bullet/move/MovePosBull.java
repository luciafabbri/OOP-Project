package bullet.move;

import utility.CheckPos;
import utility.Direction;
import utility.Pair;

public interface MovePosBull {
	
	public Pair<Integer,Integer> nextPos(Pair<Integer,Integer> pos, Direction dir, CheckPos check);
	
	public boolean isAlive();

}
