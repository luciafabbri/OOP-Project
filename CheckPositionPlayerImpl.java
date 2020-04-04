package player.movement;

import utility.Pair;
import levels.Level;

/**
 * 
 * Class that implements the method of Interface CheckPositionPlayer
 * 
 */

public class CheckPositionPlayerImpl implements CheckPositionPlayer{
	
	/** 
	 * 
	 * This method needs the coordinates of the player and checks if he's not going out of bounds
	 * If the coordinates are above these limits, the method will not change its position and returns the old coordinates
	 * Otherwise it will return null value
	 * 
	 */

	@Override
	public boolean isEnd(Pair<Integer, Integer> pos) {
		return !( (pos.getX() <= Level.TILESIZE || pos.getX() >= Level.WIDTH-Level.TILESIZE*2) 			|| 
				(pos.getY() <= Level.TILESIZE || pos.getY() >= Level.HEIGHT-Level.TILESIZE*2));		
	}
	
	// SE SOPRA LIMITI --> return FALSE
	// SE VANNO BENE --> return TRUE  

}
