package enemy.move;

import java.util.Random;

import design.RoomDesign;
import design.RoomDesignImpl;
import design.utilities.GameSettings;
import utility.CheckPosDir;
import utility.Direction;
import design.utilities.Pair;

public class TeleportMove implements MovePosMonster {
	
	private CheckPosDir check = new CheckMonster();
	private Random rand = new Random();
	private Pair<Integer,Integer> newPos;
	private Direction nextDir = null;
	private int sleepCounter = 0;
	
	private RoomDesign currentRoom;
	
	public TeleportMove(RoomDesignImpl room) {
		currentRoom = room;
	}

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
				x = rand.nextInt(GameSettings.WIDTH);
				y = rand.nextInt(GameSettings.HEIGHT);
				newPos = new Pair<>(x,y);
			} while (check.possiblePos(currentRoom, newPos, dir));
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
