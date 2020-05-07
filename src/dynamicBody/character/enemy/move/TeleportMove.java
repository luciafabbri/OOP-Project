package dynamicBody.character.enemy.move;

import java.util.Random;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import dynamicBody.character.Character;
import dynamicBody.character.enemy.move.check.CheckMonster;
import dynamicBody.character.enemy.move.check.CheckMonsterImpl;
import dynamicBody.move.Direction;

/**
 * Class that implement MovePosMonster use when enemy's movement is and Teleport
 */
public class TeleportMove implements MovePosMonster {

	private CheckMonster check;
	private Random rand = new Random();
	private Pair<Integer, Integer> newPos;
	private Direction nextDir = null;

	private RoomDesign currentRoom;

	private int sleepTime = 5000;
	private long startMillis = 0;
	private long stopMillis;

	/**
	 * Default constructor
	 * 
	 * @param room,      room where character is
	 * @param character, the character who need to move
	 */
	public TeleportMove(RoomDesign room, Character character) {
		currentRoom = room;
		check = new CheckMonsterImpl(character);
	}

	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, int speed, Direction dir) {

		stopMillis = System.currentTimeMillis();
		if (stopMillis - startMillis > sleepTime) {
			int x, y;
			do {
				x = rand.nextInt(GameSettings.WIDTH);
				y = rand.nextInt(GameSettings.HEIGHT);
				newPos = new Pair<>(x, y);
			} while (!check.possiblePos(currentRoom, newPos));
			nextDir = Direction.getRandomDir();
			startMillis = System.currentTimeMillis();
		} else {
			this.nextDir = dir;
			this.newPos = pos;
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
