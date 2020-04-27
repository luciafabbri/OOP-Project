package bullet.move;

import design.RoomDesign;
import design.utilities.Pair;
import utility.CheckPos;
import utility.Direction;

public class MoveBullImpl implements MoveBull {

	private boolean alive = true;
	
	private RoomDesign currentRoom;
	
	public MoveBullImpl(RoomDesign room) {
		currentRoom = room;
	}

	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, Direction dir, CheckPos check, int speed) {
		if(alive) {
			Pair<Integer,Integer> nextPos = new Pair<Integer,Integer>(pos.getX() + (dir.getAbscissa() * speed), pos.getY() + (dir.getOrdinate() * speed));
		
			alive = check.possiblePos(currentRoom, nextPos);
			return nextPos;
		}
		return pos;
	}

	@Override
	public boolean isAlive() {
		return alive;
	}
	
	

}
