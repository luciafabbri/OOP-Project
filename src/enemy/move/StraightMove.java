package enemy.move;

import design.RoomDesign;
import design.utilities.Pair;
import enemy.move.check.CheckMonster;
import enemy.move.check.CheckMonsterImpl;
import utility.Direction;
import utility.Character;

public class StraightMove implements MovePosMonster {

	private CheckMonster check;
	private Direction nextDir = null;

	private RoomDesign currentRoom;

	public StraightMove(RoomDesign room, Character character) {
		currentRoom = room;
		check = new CheckMonsterImpl(character);
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
