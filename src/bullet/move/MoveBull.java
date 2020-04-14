package bullet.move;

import design.RoomDesign;
import design.RoomDesignImpl;
import design.utilities.Pair;
import utility.CheckPos;
import utility.Direction;

public class MoveBull implements MovePosBull {

	private boolean alive = true;
	
	private RoomDesign currentRoom;
	
	public MoveBull(RoomDesignImpl room) {
		currentRoom = room;
	}

	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, Direction dir, CheckPos check) {
		Pair<Integer,Integer> nextPos = new Pair<Integer,Integer>(pos.getX() + dir.getAbscissa(), pos.getY() + dir.getOrdinate());
		alive = !check.possiblePos(currentRoom, nextPos);
		return nextPos;
	}

	@Override
	public boolean isAlive() {
		return alive;
	}
	
	

}
