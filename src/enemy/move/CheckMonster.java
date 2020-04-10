package enemy.move;

import design.utilities.Pair;
import enemy.Enemy;
import utility.CheckPosDir;
import utility.Direction;

public class CheckMonster implements CheckPosDir{
	
	private int limitRight=1296-48*2;
	private int limitLeft=48-1;
	private int limitUp=48-1;
	private int limitDown=720-48*2;
	
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
	
	private boolean isOutOfLimits(Pair<Integer,Integer> pos) {
		return (pos.getX() <= limitLeft || pos.getX() + Enemy.DIMENSION >= limitRight) || 
				(pos.getY() <= limitUp || pos.getY() + Enemy.DIMENSION >= limitDown);
	}
	
	@Override
	public boolean possiblePos(Pair<Integer, Integer> pos) {
		return isOutOfLimits(pos);
	}

}
