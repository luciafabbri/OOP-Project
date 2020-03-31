package utility;

import enemy.Pair;

public interface CheckPosDir extends CheckPos {
	
	public Direction checkLimits(Pair<Integer, Integer> pos, Direction dir);

}
