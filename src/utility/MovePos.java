package utility;

import utility.Pair;

public interface MovePos {
	
	public Pair<Integer,Integer> nextPos(Pair<Integer,Integer> pos, Direction dir);

}
