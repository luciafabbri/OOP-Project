package design.generation;

import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.newdawn.slick.SlickException;

import design.RoomDesign;
import design.RoomDesignImpl;
import design.tokens.Enemy;
import design.tokens.EnemyBoss;
import design.utilities.*;
import design.utilities.enums.Entities;
import design.utilities.enums.Pickupables;
import design.utilities.graphs.BidirectionalGraph;
import gameEntities.*;
import gameEntities.items.*;
import gameEntities.modifiers.*;

public class RoomDesignGeneratorImpl implements RoomDesignGenerator {

	Map<String, Integer> currentConfig;
	private Random random = new Random();
	private RandomPosition randomPosition = new CoherentRandomPosition();
	private int specialRoomID;
	private boolean isFinalLevel;

	public RoomDesignGeneratorImpl(Map<String, Integer> currentConfig, Integer specialRoomID, boolean isFinalLevel) {
		this.specialRoomID = specialRoomID;
		this.currentConfig = currentConfig;
		this.isFinalLevel = isFinalLevel;
	}

	@Override
	public RoomDesignImpl generateRoom(int index) throws SlickException  {

		RoomDesignImpl room = new RoomDesignImpl(index);
		Pair<Integer, Integer> pos;
		if (index == specialRoomID) {
			if(isFinalLevel) {
				this.generateBoss(room);
			} else {
				this.generateStairs(room);
			}
			
		}
		int numOfEnemies = currentConfig.get("minEnemies")
				+ random.nextInt(1 + currentConfig.get("maxEnemies") - currentConfig.get("minEnemies"));
		for (int j = 0; j < numOfEnemies; j++) {
			pos = randomPosition.generateRandomPosition();
			while (room.getOccupiedTiles().contains(pos)) {
				pos = randomPosition.generateRandomPosition();
			}
			room.addEnemy(new Enemy(pos));
			room.addOccupiedTile(pos);
		}
		int obstaclePercentage = currentConfig.get("minObstacles%")
				+ random.nextInt(1 + currentConfig.get("maxObstacles%") - currentConfig.get("minObstacles%"));
		int numOfObstacles;
		if (obstaclePercentage > 0) {
			numOfObstacles = GameSettings.TOTALTILES % obstaclePercentage;
		} else {
			numOfObstacles = 0;
		} 
		for (int k = 0; k < numOfObstacles; k++) {
			pos = randomPosition.generateRandomPosition();
			while (room.getOccupiedTiles().contains(pos)) {
				pos = randomPosition.generateRandomPosition();
			}
			room.addObstacle(new Obstacle(pos));
			room.addOccupiedTile(pos);
		}
		int numOfEntities = currentConfig.get("minObjects") + random.nextInt(1 + currentConfig.get("maxObjects") - currentConfig.get("minObjects"));
		try {
			this.generateEntities(room, numOfEntities);
		} catch (SlickException e) {
			e.printStackTrace();
		} 
		// tiles graph generation
		room.setTilesGraph(generateTilesGraph(room));
		return room;
	}

	private void generateEntities(RoomDesignImpl room, int numOfEntities) throws SlickException {

		for (int i = 0; i < numOfEntities; i++) {
			switch (Pickupables.valueOf(random.nextInt(Pickupables.values().length))) {
			case COIN:
				room.addEntity(new Coin(randomPosition.generateRandomPosition()));
				break;
			case KEY:
				room.addEntity(new Key(randomPosition.generateRandomPosition()));
				break;
			case ATTACKUPGRADE1:
				room.addEntity(new AttackUpgrade1(randomPosition.generateRandomPosition()));
				break;
			case HEALTHUPGRADE1:
				room.addEntity(new HealthUpgrade1(randomPosition.generateRandomPosition()));
				break;

			}
		}

	}

	private void generateStairs(RoomDesignImpl room) throws SlickException {
		room.setStairsPresence(true);
		room.setStairs(new Stairs(randomPosition.generateRandomPosition()));
		room.addOccupiedTile(room.getStairs().getPosition());
	}
	
	private void generateBoss(RoomDesignImpl room) {
		room.addEnemy(new EnemyBoss(randomPosition.generateRandomPosition()));
	}

	private BidirectionalGraph<Pair<Integer, Integer>> generateTilesGraph(RoomDesign room) {
		BidirectionalGraph<Pair<Integer, Integer>> graph = new BidirectionalGraph<>();
		for (int x = GameSettings.TILESIZE; x <= GameSettings.WIDTH; x += 64) {
			for (int y = GameSettings.TILESIZE; y <= GameSettings.HEIGHT; y += 64) {
				Pair<Integer, Integer> tilePos = new Pair<Integer, Integer>(x, y);
				if (!room.getObstaclePositions().contains(tilePos)) {
					if (!graph.getNodes().contains(tilePos)) {
						graph.addNode(tilePos);
					}
					computeAdjacentTile(tilePos).forEach(t -> {
						if (!room.getObstaclePositions().contains(t) && !graph.getEdges(tilePos).contains(t)) {
							if (!graph.getNodes().contains(t)) {
								graph.addNode(t);
							}
							graph.addEdge(tilePos, t);
						}
					});
				}
			}
		}
		return graph;

	}

	private LinkedList<Pair<Integer, Integer>> computeAdjacentTile(Pair<Integer, Integer> tilePosition) {
		LinkedList<Pair<Integer, Integer>> list = new LinkedList<>();
		Pair<Integer, Integer> upperTile = new Pair<Integer, Integer>(tilePosition.getX() - 64, tilePosition.getY());
		Pair<Integer, Integer> lowerTile = new Pair<Integer, Integer>(tilePosition.getX() + 64, tilePosition.getY());
		Pair<Integer, Integer> leftTile = new Pair<Integer, Integer>(tilePosition.getX(), tilePosition.getY() - 64);
		Pair<Integer, Integer> rightTile = new Pair<Integer, Integer>(tilePosition.getX(), tilePosition.getY() + 64);
		if (upperTile.getX() >= GameSettings.TILESIZE) {
			list.add(upperTile);
		}
		if (lowerTile.getX() <= GameSettings.WIDTH) {
			list.add(lowerTile);
		}
		if (leftTile.getY() >= GameSettings.TILESIZE) {
			list.add(leftTile);
		}
		if (rightTile.getY() <= GameSettings.HEIGHT) {
			list.add(rightTile);
		}
		return list;

	}

}
