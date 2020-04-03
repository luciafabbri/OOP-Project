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
	public Pair<Integer, Integer> checkLimitsPosition(Pair<Integer, Integer> pos, Direction dir) {
		if( (pos.getX() >= Level.TILESIZE || pos.getX() >= Level.WIDTH-Level.TILESIZE) 			|| 
				(pos.getY() >= Level.TILESIZE || pos.getY() >= Level.HEIGHT-Level.TILESIZE))
			return pos;
		return null;
	}	
	// SE SOPRA LIMITI --> VECCHIE CORDINATE
	// SE VANNO BENE --> NULL  

	
}
