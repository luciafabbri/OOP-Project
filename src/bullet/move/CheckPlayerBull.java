package bullet.move;

import design.utilities.GameSettings;
import design.utilities.Pair;
import utility.CheckPos;

public class CheckPlayerBull implements CheckPos, GameSettings {
	
	//controllo degli ostacoli e dei nemici in caso vengano colpiti ancora da fare 
	
	private boolean isOutOfLimits(Pair<Integer, Integer> pos) {
		return ( (pos.getX() < TILESIZE || pos.getX() >= WIDTH-TILESIZE*2) 			|| 
				(pos.getY() < TILESIZE || pos.getY() >= HEIGHT-TILESIZE*2) );	
	}

	@Override
	public boolean possiblePos(Pair<Integer, Integer> pos) {
		return isOutOfLimits(pos);
	}
}