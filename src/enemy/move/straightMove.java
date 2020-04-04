package enemy.move;

import utility.Pair;
import utility.CheckPosDir;
import utility.Direction;

public class straightMove implements MovePosMonster{
	
	private CheckPosDir check = new checkMonster();
	private Direction newDir;

	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, Direction dir) {

		Pair<Integer,Integer> nextPos = new Pair<Integer,Integer>(pos.getX() + dir.getAbscissa(), pos.getY() + dir.getOrdinate());
		newDir=dir;
		
		if(check.isOutOfLimits(nextPos)) {
			this.newDir = check.changeDir(nextPos, dir);	
			return pos;			
		} else {	
			return nextPos;
		}
		
	}

	@Override
	public Direction getDirection() {
		return newDir;
	}
}
