package bullet.move;


import utility.Pair;
import utility.CheckPos;
import utility.Direction;

public class moveBull implements MovePosBull {

	private boolean alive = true;
	
	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, Direction dir, CheckPos check) {
		Pair<Integer,Integer> nextPos = new Pair<Integer,Integer>(pos.getX() + dir.getAbscissa(), pos.getY() + dir.getOrdinate());
		alive = !check.isOutOfLimits(nextPos);
		return nextPos;
	}

	@Override
	public boolean isAlive() {
		return alive;
	}
	
	

}
