package entity.bullet.move;

import design.RoomDesign;
import design.utilities.Pair;
import entity.move.CheckPos;
import entity.move.Direction;
import entity.move.Speed;

public class MoveBullImpl implements MoveBull {

	private boolean alive = true;
	private boolean test = true;
	
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
