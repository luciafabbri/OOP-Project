package design.generation;

import java.util.Random;

import org.newdawn.slick.SlickException;
import design.RoomDesignImpl;
import design.tokens.*;
import design.utilities.*;
import design.utilities.enums.Pickupables;
import gameEntities.*;
import gameEntities.items.*;
import gameEntities.modifiers.*;

public class EntitiesGeneratorImpl implements EntitiesGenerator {
	
	private final RoomDesignImpl room;
	private final RandomPosition randomPosition = new CoherentRandomPosition();
	private final Random random = new Random();
	private Pair<Integer, Integer> pos;
	
	public EntitiesGeneratorImpl(RoomDesignImpl room) {
		this.room = room;
	}

	@Override
	public void generatePickupables(int numOfPickupables) throws SlickException {
		for (int i = 0; i < numOfPickupables; i++) {
			switch (Pickupables.valueOf(random.nextInt(Pickupables.values().length))) {
			case COIN:
				room.addPickupable(new Coin(randomPosition.generateRandomPosition()));
				break;
			case KEY:
				room.addPickupable(new Key(randomPosition.generateRandomPosition()));
				break;
			case ATTACKUPGRADE1:
				room.addPickupable(new AttackUpgrade1(randomPosition.generateRandomPosition()));
				break;
			case HEALTHUPGRADE1:
				room.addPickupable(new HealthUpgrade1(randomPosition.generateRandomPosition()));
				break;

			}
		}

	}

	@Override
	public void generateStairs() throws SlickException {
		room.setStairsPresence(true);
		room.setStairs(new Stairs(randomPosition.generateRandomPosition()));
		room.addOccupiedTile(room.getStairs().getPosition());

	}

	@Override
	public void generateBoss() throws SlickException{
		room.addEnemy(new EnemyBoss(randomPosition.generateRandomPosition()));

	}

	@Override
	public void generateEnemies(int numOfEnemies) throws SlickException{
		for (int j = 0; j < numOfEnemies; j++) {
			pos = randomPosition.generateRandomPosition();
			while (room.getOccupiedTiles().contains(pos)) {
				pos = randomPosition.generateRandomPosition();
			}
			room.addEnemy(new Enemy(pos));
			room.addOccupiedTile(pos);
		}

	}

	@Override
	public void generateObstacles(int numOfObstacles) throws SlickException {
		for (int k = 0; k < numOfObstacles; k++) {
			pos = randomPosition.generateRandomPosition();
			while (room.getOccupiedTiles().contains(pos)) {
				pos = randomPosition.generateRandomPosition();
			}
			room.addObstacle(new Obstacle(pos));
			room.addOccupiedTile(pos);
		}
	}

}
