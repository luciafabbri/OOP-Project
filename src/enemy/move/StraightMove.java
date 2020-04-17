package enemy.move;

import design.RoomDesign;
import design.utilities.Pair;
import utility.CheckPosDir;
import utility.Direction;

public class StraightMove implements MovePosMonster {

	private CheckPosDir check = new CheckMonster();
	private Direction nextDir = null;

	private RoomDesign currentRoom;

	public StraightMove(RoomDesign room) {
		currentRoom = room;
	}

	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, Direction dir) {

		Pair<Integer, Integer> nextPos = new Pair<Integer, Integer>(pos.getX() + dir.getAbscissa(),
				pos.getY() + dir.getOrdinate());
		nextDir = dir;

		if (check.possiblePos(currentRoom, nextPos)) {
			return nextPos;
		} else {
			this.nextDir = check.changeDir(currentRoom, nextPos, dir);
			return pos;

		}

	}

	@Override
	public Direction getDirection() {
		if (nextDir == null) {
			throw new IllegalStateException(" Direction isn't Initialized ");
		}
		return nextDir;
	}
}
