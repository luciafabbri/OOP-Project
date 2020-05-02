package design.generation;

import java.util.Map;
import java.util.Random;

import org.newdawn.slick.SlickException;
import design.RoomDesignImpl;
import design.utilities.*;
import design.utilities.enums.Pickupables;
import design.utilities.graphs.RoomBFS;
import entity.character.enemy.*;
import gameEntities.*;
import gameEntities.items.*;
import gameEntities.modifiers.*;

/**
 * Implementation of interface EntitiesGenerator
 *
 */
public class EntitiesGeneratorImpl implements EntitiesGenerator {

	private final RoomDesignImpl room;
	private final Map<String, Integer> currentConfig;
	private final RandomPosition randomPosition = new CoherentRandomPosition();
	private final Random random = new Random();
	private Pair<Integer, Integer> pos;
	private final EnemyCreatorImpl enemyGen = new EnemyCreatorImpl();

	/**
	 * @param room           that the generator applies to
	 * @param currentConfig, configuration map to be used
	 */
	public EntitiesGeneratorImpl(RoomDesignImpl room, Map<String, Integer> currentConfig) {
		this.room = room;
		this.currentConfig = currentConfig;
	}

	/**
	 * @return a random tile not yet occupied inside the room
	 */
	private Pair<Integer, Integer> generateCoherentPos() {
		pos = randomPosition.generateRandomPosition();
		while (room.getOccupiedTiles().contains(pos) || RoomBFS.getDoorpositions().contains(pos)) {
			pos = randomPosition.generateRandomPosition();
		}
		room.addOccupiedTile(pos);
		return pos;

	}

	@Override
	public void generatePickupables(int numOfPickupables) throws SlickException {
		for (int i = 0; i < numOfPickupables; i++) {
			pos = generateCoherentPos();
			switch (Pickupables.valueOf(random.nextInt(Pickupables.values().length))) {
			case COIN:
				room.addPickupable(new Coin(pos));
				break;
			case KEY:
				room.addPickupable(new Key(pos));
				break;
			case ATTACKUPGRADE1:
				room.addPickupable(new AttackUpgrade1(pos));
				break;
			case HEALTHUPGRADE1:
				room.addPickupable(new HealthUpgrade1(pos));
				break;
			case ATTACKSPEED1:
				room.addPickupable(new AttackSpeed1(pos));
				break;
			case MOVEMENTSPEED1:
				room.addPickupable(new MovementSpeed1(pos));
			}
		}

	}

	@Override
	public void generateStairs() throws SlickException {
		room.setStairsPresence(true);
		pos = generateCoherentPos();
		room.setStairs(new Stairs(pos));

	}

	@Override
	public void generateBoss() throws SlickException {
		pos = generateCoherentPos();
		room.addEnemy(enemyGen.getBossA(pos, room));

	}

	@Override
	public void generateEnemies(int numOfEnemies) throws SlickException {
		for (int j = 0; j < numOfEnemies; j++) {
			pos = generateCoherentPos();
			room.addEnemy(enemyGen.getMonsterA(pos, currentConfig.get("enemyHealth"), currentConfig.get("enemyDamage"),
					room));
		}

	}

	@Override
	public void generateObstacles(int numOfObstacles) throws SlickException {
		for (int k = 0; k < numOfObstacles; k++) {
			pos = generateCoherentPos();
			room.addObstacle(new Obstacle(pos));
		}
	}

}
