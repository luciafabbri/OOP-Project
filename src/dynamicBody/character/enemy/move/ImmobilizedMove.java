package dynamicBody.character.enemy.move;

import design.utilities.Pair;
import dynamicBody.move.Direction;

/**
 * Class that implement MovePosMonster use when enemy's movement is Immobilized
 */
public class ImmobilizedMove implements MovePosMonster {

	private Direction nextDir;

	public ImmobilizedMove() {
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
