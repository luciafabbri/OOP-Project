package enemy.move;

import enemy.Pair;
import utility.CheckPosDir;
import utility.Direction;

public class straightMove implements MovePosMonst{
	
	private CheckPosDir check = new checkMonster();
	private Direction newDir;

	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, Direction dir) {

		Pair<Integer,Integer> nextPos = new Pair<Integer,Integer>(pos.getX() + dir.getAbscissa(), pos.getY() + dir.getOrdinate());
		
		if(check.isEnd(nextPos)) {
			this.newDir = check.checkLimits(nextPos, dir);
			return pos;
		} else {		
			return new Pair<Integer,Integer>(pos.getX() + newDir.getAbscissa(), pos.getY() + newDir.getOrdinate());
		}
	}

	@Override
	public Direction getDirection() {
		return newDir;
	}
}
