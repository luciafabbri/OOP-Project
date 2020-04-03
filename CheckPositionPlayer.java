package player.movement;

import utility.Pair;

public interface CheckPositionPlayer {
	
	/** 
	 * 
	 * This method needs the coordinates of the player and checks if he's not going out of bounds
	 * If the coordinates are above these limits, the method will not change its position and returns the old coordinates
	 * Otherwise it will return null value
	 * 
	 */
	public Pair<Integer,Integer> checkLimitsPosition(Pair<Integer,Integer> pos, Direction dir);

}
