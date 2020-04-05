package enemy.move;

import utility.Pair;
import levels.Level;
import utility.CheckPosDir;
import utility.Direction;

public class checkMonster implements CheckPosDir{
	
	private int limitRight=Level.WIDTH-Level.TILESIZE*2;
	private int limitLeft=Level.TILESIZE-1;
	private int limitUp=Level.TILESIZE-1;
	private int limitDown=Level.HEIGHT-Level.TILESIZE*2;
	
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
	public boolean isOutOfLimits(Pair<Integer,Integer> pos) {
		return (pos.getX() <= limitLeft || pos.getX() >= limitRight) || (pos.getY() <= limitUp || pos.getY() >= limitDown);
	}

}
