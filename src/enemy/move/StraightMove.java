package enemy.move;

import utility.Pair;
import utility.CheckPosDir;
import utility.Direction;

public class StraightMove implements MovePosMonster{
	
	private CheckPosDir check = new CheckMonster();
	private Direction newDir;

	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, Direction dir) {

		Pair<Integer,Integer> nextPos = new Pair<Integer,Integer>(pos.getX() + dir.getAbscissa(), pos.getY() + dir.getOrdinate());
		newDir=dir;
		
		if(check.possiblePos(nextPos)) {
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
