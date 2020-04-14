package enemy.move;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import enemy.Enemy;
import utility.CheckPosDir;
import utility.Direction;

public class CheckMonster implements CheckPosDir {
	
	private int x, y;
	private Direction newDir;
	
	@Override
	public Direction changeDir(Pair<Integer, Integer> pos, Direction dir) {

		if(pos.getX() >= GameSettings.LIMITRIGHT) {
			this.x = -1;
		} else if (pos.getX() <= GameSettings.LIMITLEFT) {
			this.x = 1;
		} else {
			this.x = dir.getAbscissa();
		}
		
		if(pos.getY() >= GameSettings.LIMITDOWN) {
			
			y = -1;
		} else if (pos.getY() <= GameSettings.LIMITUP) {
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
		return (pos.getX() <= GameSettings.LIMITLEFT || pos.getX() + Enemy.DIMENSION >= GameSettings.LIMITLEFT) || 
				(pos.getY() <= GameSettings.LIMITUP || pos.getY() + Enemy.DIMENSION >= GameSettings.LIMITDOWN);
	}
	
	private boolean isOnObstacle(Pair<Integer,Integer> pos) {
		return false;
	}
	
	

}
