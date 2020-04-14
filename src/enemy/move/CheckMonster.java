package enemy.move;

import design.RoomDesign;
import design.RoomDesignImpl;
import design.utilities.GameSettings;
import design.utilities.Pair;
import enemy.Enemy;
import player.movement.CheckPositionPlayerImpl;
import utility.CheckPosDir;
import utility.Direction;

public class CheckMonster implements CheckPosDir{
	
	private int limitRight = GameSettings.WIDTH - GameSettings.HEIGHT;
	private int limitLeft = GameSettings.TILESIZE - 1;
	private int limitUp = GameSettings.TILESIZE - 1;
	private int limitDown = GameSettings.HEIGHT - GameSettings.TILESIZE;
	
	private int x, y;
	private Direction newDir;
	
	@Override
	public Direction changeDir(Pair<Integer, Integer> pos, Direction dir) {

		if(pos.getX() >= limitRight) {
			this.x = -1;
		} else if (pos.getX() <= limitLeft) {
			this.x = 1;
		} else {
			this.x = dir.getAbscissa();
		}
		
		if(pos.getY() >= limitDown) {
			
			y = -1;
		} else if (pos.getY() <= limitUp) {
			y = 1;
		} else {
			this.y = dir.getOrdinate();
		}
		
		for(Direction d : Direction.values()) {
			if(d.getAbscissa() == x && d.getOrdinate() == y) {
				this.newDir=d;
			}
		}
		
		return newDir;
	}
	
	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		return !isOutOfLimits(pos) || !isOnObstacle(pos);
	}
	
	private boolean isOutOfLimits(Pair<Integer,Integer> pos) {
		return (pos.getX() <= limitLeft || pos.getX() + Enemy.DIMENSION >= limitRight) || 
				(pos.getY() <= limitUp || pos.getY() + Enemy.DIMENSION >= limitDown);
	}
	
	private boolean isOnObstacle(Pair<Integer,Integer> pos) {
		return false;
	}
	
	

}
