package player.movement;

import utility.Pair;
import design.utilities.GameSettings;
import levels.Level;

/**
 * 
 * Class that implements the method of the extended interface CheckPos
 * 
 */

public class CheckPositionPlayerImpl implements CheckPositionPlayer, GameSettings{
	
	/** 
	 * 
	 * This method needs the coordinates of the player and checks if he's not going out of bounds.
	 * If the coordinates are above these limits, the method will return FALSE value otherwise it will return TRUE.
	 *  SE SOPRA LIMITI --> return FALSE
	 *  SE VANNO BENE --> return TRUE  
	 *  
	 */

	private boolean isOutOfLimits(Pair<Integer, Integer> pos) {
		return !( (pos.getX() <= TILESIZE || pos.getX() >= WIDTH-TILESIZE*2) 			|| 
				(pos.getY() <= TILESIZE || pos.getY() >= HEIGHT-TILESIZE*2) );		
	}
	
	@Override
	public boolean possiblePos(Pair<Integer, Integer> pos) {
		return isOutOfLimits(pos);
	}
	
}
