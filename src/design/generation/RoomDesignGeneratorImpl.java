package design.generation;

import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

import design.RoomDesign;
import design.RoomDesignImpl;
import design.tokens.Enemy;
import design.utilities.BidirectionalGraph;
import design.utilities.CoherentRandomPosition;
import design.utilities.GameSettings;
import design.utilities.Pair;
import design.utilities.RandomPosition;

public class RoomDesignGeneratorImpl implements RoomDesignGenerator{

	Map<String, Integer> currentConfig;
	private Random random = new Random();
	private RandomPosition randomPosition = new CoherentRandomPosition();
	
	public RoomDesignGeneratorImpl(Map<String, Integer> currentConfig) {
		this.currentConfig = currentConfig;
	}



	@Override
	public RoomDesign generateRoom(int index) {

		RoomDesignImpl room = new RoomDesignImpl(index);
		Pair<Integer, Integer> pos;
		int numOfEnemies = currentConfig.get("minEnemies") + random.nextInt(1 + currentConfig.get("maxEnemies") - currentConfig.get("minEnemies"));
		for(int j = 0; j < numOfEnemies; j++) {
			pos = randomPosition.generateRandomPosition();
			while(room.getOccupiedTiles().contains(pos)) {
				pos = randomPosition.generateRandomPosition();
			}
			room.addEnemy(new Enemy(pos));
			room.addOccupiedTile(pos);
		}
		int obstaclePercentage = currentConfig.get("minObstacles%") + random.nextInt(1 + currentConfig.get("maxObstacles%") - currentConfig.get("minObstacles%"));
		int numOfObstacles;
		if(obstaclePercentage > 0) {
			numOfObstacles = GameSettings.TOTALTILES % obstaclePercentage;
		}
		else {
			numOfObstacles = 0;
		}
		for(int k = 0; k < numOfObstacles; k++) {
			pos = randomPosition.generateRandomPosition();
			while(room.getOccupiedTiles().contains(pos)) {
				pos = randomPosition.generateRandomPosition();
			}
			room.addObstacle(new gameEntities.Obstacle(pos));
			room.addOccupiedTile(pos);
		}
		// tiles graph generation
		room.setTilesGraph(generateTilesGraph(room));
		return room;
	}

	private BidirectionalGraph<Pair<Integer, Integer>> generateTilesGraph(RoomDesign room) {
		BidirectionalGraph<Pair<Integer, Integer>> graph = new BidirectionalGraph<>(); 
		for(int x = GameSettings.TILESIZE; x <= GameSettings.WIDTH; x+= 64 ) {
			for(int y = GameSettings.TILESIZE; y <= GameSettings.HEIGHT; y+= 64) {
				Pair<Integer, Integer> tilePos = new Pair<Integer, Integer>(x, y);
				if(!room.getObstaclePositions().contains(tilePos)) {
					if(!graph.getNodes().contains(tilePos)) {
						graph.addNode(tilePos);
					}
					computeAdjacentTile(tilePos).forEach(t -> {
						if(!room.getObstaclePositions().contains(t) && !graph.getEdges(tilePos).contains(t)) {
							if(!graph.getNodes().contains(t)) {
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
		if(upperTile.getX()>= GameSettings.TILESIZE) {
			list.add(upperTile);
		}
		if(lowerTile.getX() <= GameSettings.WIDTH) {
			list.add(lowerTile);
		}
		if(leftTile.getY()>= GameSettings.TILESIZE) {
			list.add(leftTile);
		}
		if(rightTile.getY() <= GameSettings.HEIGHT) {
			list.add(rightTile);
		}
		return list;
		
	}
	
}
