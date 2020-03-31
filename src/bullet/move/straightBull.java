package bullet.move;


import enemy.Pair;
import utility.CheckPos;
import utility.Direction;

public class straightBull implements MovePosBull {

	private CheckPos limitCheck = new checkBullet();
	private boolean alive = true;
	
	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, Direction dir) {
		Pair<Integer,Integer> nextPos = new Pair<Integer,Integer>(pos.getX() + dir.getAbscissa(), pos.getY() + dir.getOrdinate());
		alive = !limitCheck.isEnd(nextPos);
		return nextPos;
	}

	@Override
	public boolean isAlive() {
		return alive;
	}
	
	

}
