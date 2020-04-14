package enemy.move;

import java.util.Random;

import utility.Direction;
import design.RoomDesignImpl;
import design.utilities.Pair;

public class RandomMove implements MovePosMonster {
	
	private static final int MINIMUM_STEPS = 20;
	private static final int RANDOM_ADD = 10;

	private MovePosMonster move; 
	private int moveCounter = 0;
	private Random random = new Random();	
	private Direction nextDir;
	
	public RandomMove(RoomDesignImpl room) {
		move = new StraightMove(room);
	}
	
	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, Direction dir) {
		Pair<Integer, Integer> nextPos = move.nextPos(pos, dir);
		if(moveCounter <= 0 || enableMov(dir)) {		
			moveCounter = random.nextInt(RANDOM_ADD)+MINIMUM_STEPS;
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

	private boolean enableMov(Direction dir){
		return move.getDirection()!=dir;
	}
}
