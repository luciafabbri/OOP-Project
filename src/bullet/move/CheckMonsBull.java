package bullet.move;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import bullet.Bullet;
import utility.CheckPos;
import utility.Direction;

public class CheckMonsBull implements CheckPos, GameSettings {
	
	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos, Direction dir) {
		return !isOutOfLimits(pos) || !isOnObstacle(pos) || !hittedPlayer(pos) ;
	}

	private boolean isOutOfLimits(Pair<Integer, Integer> pos) {
		return (pos.getX() <= LIMITLEFT || pos.getX() + Bullet.DIMENSION >= LIMITRIGHT) || 
				(pos.getY() <= LIMITUP || pos.getY() + Bullet.DIMENSION >= LIMITDOWN);
	}
	
	private boolean isOnObstacle(Pair<Integer,Integer> pos) {
		return false;
	}
	
	private boolean hittedPlayer(Pair<Integer, Integer> pos) {
		return false;
	}
}
