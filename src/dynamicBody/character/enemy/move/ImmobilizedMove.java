package dynamicBody.character.enemy.move;

import design.RoomDesign;
import design.utilities.Pair;
import dynamicBody.move.Direction;

public class ImmobilizedMove implements MovePosMonster {

	private Direction nextDir;

	public ImmobilizedMove(RoomDesign room) {
	}

	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, int speed, Direction dir) {
		nextDir = dir;
		return pos;
	}

	@Override
	public Direction getDirection() {
		return nextDir;
	}

}
