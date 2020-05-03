package dynamicBody.character.enemy.move;

import design.RoomDesign;
import design.utilities.Pair;
import dynamicBody.character.Character;
import dynamicBody.character.enemy.move.check.CheckMonster;
import dynamicBody.character.enemy.move.check.CheckMonsterImpl;
import dynamicBody.move.Direction;

public class StraightMove implements MovePosMonster {

	private CheckMonster check;
	private Direction nextDir = null;

	private RoomDesign currentRoom;

	public StraightMove(RoomDesign room, Character character) {
		currentRoom = room;
		check = new CheckMonsterImpl(character);
	}

	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, int speed, Direction dir) {

		Pair<Integer, Integer> nextPos = new Pair<Integer, Integer>(pos.getX() + (dir.getAbscissa() * speed),
				pos.getY() + (dir.getOrdinate() * speed));
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
