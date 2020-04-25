package enemy.move;

import java.util.Random;

import utility.Direction;
import design.RoomDesign;
import design.utilities.Pair;
import utility.Character;

public class RandomMove implements MovePosMonster {

	private static final int MINIMUM_STEPS = 250;
	private static final int RANDOM_ADD = 130;

	private MovePosMonster move;
	private int moveCounter = 0;
	private Random random = new Random();
	private Direction nextDir;

	public RandomMove(RoomDesign room, Character character) {
		move = new StraightMove(room, character);
	}

	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, int speed, Direction dir) {
		Pair<Integer, Integer> nextPos = move.nextPos(pos, speed, dir);
		if (moveCounter <= 0 || enableMov(dir)) {
			moveCounter = random.nextInt(RANDOM_ADD) + MINIMUM_STEPS;
			nextDir = Direction.getRandomDir();
			nextPos = pos;
		} else {
			moveCounter--;
			nextDir = dir;
		}
		return nextPos;
	}

	@Override
	public Direction getDirection() {
		if (nextDir == null) {
			throw new IllegalStateException(" Direction isn't Initialized ");
		}
		return nextDir;
	}

	private boolean enableMov(Direction dir) {
		return move.getDirection() != dir;
	}
}
