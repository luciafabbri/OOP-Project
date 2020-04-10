package enemy.move;

import java.util.Random;

import utility.CheckPosDir;
import utility.Direction;
import utility.Pair;

public class TeleportMove implements MovePosMonster {
	
	private CheckPosDir check = new CheckMonster();
	private Random rand = new Random();
	private Pair<Integer,Integer> newPos;
	private Direction nextDir = null;
	private int sleepCounter = 0;

	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, Direction dir) {
		
		if(this.sleepCounter > 0) {
			this.sleepCounter--;
			this.nextDir = dir;
			this.newPos = pos;
		} else {
			int x, y;
			this.sleepCounter=20;
			do {
				x = rand.nextInt(1296);
				y = rand.nextInt(720);
				newPos = new Pair<>(x,y);
			} while (check.possiblePos(newPos));
			nextDir = Direction.getRandomDir();
		}
		return newPos;
	}

	@Override
	public Direction getDirection() {
		if (nextDir == null) {
			throw new IllegalStateException(" Direction isn't Initialized ");
		}
		return nextDir;
	}
	
	

}
