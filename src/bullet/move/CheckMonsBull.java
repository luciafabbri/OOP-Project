package bullet.move;

import utility.Pair;
import bullet.Bullet;
import utility.CheckPos;

public class CheckMonsBull implements CheckPos {
	
	private int limitRight=1296-48*2;
	private int limitLeft=48;
	private int limitUp=48;
	private int limitDown=720-48*2;
	

	private boolean isOutOfLimits(Pair<Integer, Integer> pos) {
		return (pos.getX() <= limitLeft || pos.getX() + Bullet.DIMENSION >= limitRight) || 
				(pos.getY() <= limitUp || pos.getY() + Bullet.DIMENSION >= limitDown);
	}


	@Override
	public boolean possiblePos(Pair<Integer, Integer> pos) {
		return isOutOfLimits(pos);
	}

}
