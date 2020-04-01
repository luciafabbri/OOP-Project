package bullet.move;

import utility.Pair;
import levels.Level;
import utility.CheckPos;

public class checkBullet implements CheckPos {
	
	private int limitRight=Level.WIDTH-Level.TILESIZE*2;
	private int limitLeft=Level.TILESIZE;
	private int limitUp=Level.TILESIZE;
	private int limitDown=Level.HEIGHT-Level.TILESIZE*2;
	

	@Override
	public boolean isEnd(Pair<Integer, Integer> pos) {
		return (pos.getX() <= limitLeft || pos.getX() >= limitRight) || (pos.getY() <= limitUp || pos.getY() >= limitDown);
	}

}
