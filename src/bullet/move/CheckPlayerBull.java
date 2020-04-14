package bullet.move;

import bullet.Bullet;
import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import utility.CheckPos;

public class CheckPlayerBull implements CheckPos, GameSettings {
	
	//controllo degli ostacoli e dei nemici in caso vengano colpiti ancora da fare 

	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		return !isOutOfLimits(pos);
	}
	
	private boolean isOutOfLimits(Pair<Integer, Integer> pos) {
		return (pos.getX() <= LIMITLEFT || pos.getX() + Bullet.DIMENSION >= LIMITRIGHT) || 
				(pos.getY() <= LIMITUP || pos.getY() + Bullet.DIMENSION >= LIMITDOWN);
	}
	
	private boolean checkObstacle(RoomDesign room, Pair<Integer, Integer> pos) {
		//CONTROLLARE PRIMA CODICE PLAYER
		return false;
	}
	
	private boolean checkEnemyHit(RoomDesign room, Pair<Integer, Integer> pos) {
		//CONTROLLARE PRIMA CODICE PLAYER
		return false;
	}
}