package bullet.move;

import design.RoomDesign;
import design.utilities.Pair;
import entity.move.CheckPos;
import entity.move.Direction;

public class MoveBullImpl implements MoveBull {

	private boolean alive = true;
	private boolean test = true;
	
	private RoomDesign currentRoom;
	
	public MoveBullImpl(RoomDesign room) {
		currentRoom = room;
	}

	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, Direction dir, CheckPos check, int speed) {
		int speedTest;
		if(alive) {
			if(test) {
				test = false;
				speedTest = 1;
			} else {
				test = true;
				speedTest = 2;
			}
			System.out.println(speedTest);
			Pair<Integer,Integer> nextPos = new Pair<Integer,Integer>(pos.getX() + (dir.getAbscissa() * speedTest), pos.getY() + (dir.getOrdinate() * speedTest));
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
