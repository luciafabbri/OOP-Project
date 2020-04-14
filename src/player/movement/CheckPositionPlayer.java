package player.movement;

import design.RoomDesignImpl;
import design.utilities.Pair;
import utility.CheckPos;

public interface CheckPositionPlayer extends CheckPos {

	boolean possiblePos(RoomDesignImpl room, Pair<Integer, Integer> pos);

	/** 
	 * 
	 * interface that extends CheckPos, in which we found "isOutOfLimits" method
	 * 
	 */
}
