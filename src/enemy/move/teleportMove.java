package enemy.move;

import java.util.Random;

import levels.Level;
import utility.CheckPosDir;
import utility.Direction;
import utility.Pair;

public class teleportMove implements MovePosMonst {
	
	private CheckPosDir check = new checkMonster();
	private Random rand = new Random();
	private Pair<Integer,Integer> newPos;
	private Direction newDir;
	private int sleepCounter = 0;

	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, Direction dir) {
		
		if(this.sleepCounter > 0) {
			this.sleepCounter--;
			this.newDir = dir;
			this.newPos = pos;
		} else {
			int x, y;
			this.sleepCounter=20;
			do {
				x = rand.nextInt(Level.WIDTH);
				y = rand.nextInt(Level.HEIGHT);
				newPos = new Pair<>(x,y);
			} while (check.isEnd(newPos));
			newDir = Direction.getRandomDir();
		}
		return newPos;
	}

	@Override
	public Direction getDirection() {
		return this.newDir;
	}
	
	

}
