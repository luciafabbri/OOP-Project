package utility;

import utility.Pair;

public interface CheckPosDir extends CheckPos {
	
	public Direction changeDir(Pair<Integer, Integer> pos, Direction dir);

}
