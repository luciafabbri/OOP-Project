package bullet.move;

import utility.Pair;
import utility.CheckPos;

public class checkMonsBull implements CheckPos {
	
	private int limitRight=1296-48*2;
	private int limitLeft=48;
	private int limitUp=48;
	private int limitDown=720-48*2;
	

	@Override
	public boolean isOutOfLimits(Pair<Integer, Integer> pos) {
		return (pos.getX() <= limitLeft || pos.getX() >= limitRight) || (pos.getY() <= limitUp || pos.getY() >= limitDown);
	}

}
