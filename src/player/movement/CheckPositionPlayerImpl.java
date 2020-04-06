package player.movement;

import utility.Pair;
import levels.Level;

/**
 * 
 * Class that implements the method of the extended interface CheckPos
 * 
 */

public class CheckPositionPlayerImpl implements CheckPositionPlayer{
	
	/** 
	 * 
	 * This method needs the coordinates of the player and checks if he's not going out of bounds.
	 * If the coordinates are above these limits, the method will return FALSE value otherwise it will return TRUE.
	 *  SE SOPRA LIMITI --> return FALSE
	 *  SE VANNO BENE --> return TRUE  
	 *  
	 */

	@Override
	public boolean isOutOfLimits(Pair<Integer, Integer> pos) {
		return !( (pos.getX() <= Level.TILESIZE || pos.getX() >= Level.WIDTH-Level.TILESIZE*2) 			|| 
				(pos.getY() <= Level.TILESIZE || pos.getY() >= Level.HEIGHT-Level.TILESIZE*2) );		
	}
	
}
