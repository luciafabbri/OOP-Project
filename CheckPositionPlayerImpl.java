package player.movement;

import utility.Pair;
import levels.Level;

/**
 * 
 * Class that implements the method of Interface CheckPositionPlayer
 * 
 */

public class CheckPositionPlayerImpl implements CheckPositionPlayer{

	@Override
	public boolean checkLimitsPosition(Pair<Integer, Integer> pos, Direction dir) {
		if( (pos.getX() >= Level.TILESIZE || pos.getX() >= Level.WIDTH-Level.TILESIZE) 			|| 
				(pos.getY() >= Level.TILESIZE || pos.getY() >= Level.HEIGHT-Level.TILESIZE))
			return false;
		return true;
	}	
	// SE SOPRA LIMITI --> return FALSE
	// SE VANNO BENE --> return TRUE  
	

	
}
