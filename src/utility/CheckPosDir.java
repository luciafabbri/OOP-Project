package utility;

import utility.Pair;

public interface CheckPosDir extends CheckPos {
	
	public Direction checkLimits(Pair<Integer, Integer> pos, Direction dir);

}
