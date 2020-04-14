package bullet.move;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import bullet.Bullet;
import utility.CheckPos;

public class CheckMonsBull implements CheckPos {
	
	private int limitRight = GameSettings.WIDTH - GameSettings.HEIGHT;
	private int limitLeft = GameSettings.TILESIZE - 1;
	private int limitUp = GameSettings.TILESIZE - 1;
	private int limitDown = GameSettings.HEIGHT - GameSettings.TILESIZE;
	
	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		return !isOutOfLimits(pos) || !isOnObstacle(pos) || !hittedPlayer(pos) ;
	}

	private boolean isOutOfLimits(Pair<Integer, Integer> pos) {
		return (pos.getX() <= limitLeft || pos.getX() + Bullet.DIMENSION >= limitRight) || 
				(pos.getY() <= limitUp || pos.getY() + Bullet.DIMENSION >= limitDown);
	}
	
	private boolean isOnObstacle(Pair<Integer,Integer> pos) {
		return false;
	}
	
	private boolean hittedPlayer(Pair<Integer, Integer> pos) {
		return false;
	}
}
