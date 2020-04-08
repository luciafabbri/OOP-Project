package design;
import java.io.*;
import java.util.*;

import design.tokens.Enemy;
import design.utilities.BidirectionalGraph;
import design.utilities.CoherentRandomPosition;
import design.utilities.GameSettings;
import design.utilities.Pair;
import design.utilities.RandomPosition;

public class LevelDesignGeneratorImpl implements LevelDesignGenerator {
	
	Random random = new Random();
	RandomPosition randomPosition = new CoherentRandomPosition();
	Map<String, Integer> currentConfig = new HashMap<>();
	
	private Map<String, Integer> getLevelConfig(Integer levelNumber) throws IOException {
		Map<String, Integer> configMap = new HashMap<>();
		File file = new File("res/levelConfigs/level"+ levelNumber + ".txt" );   
		BufferedReader br = new BufferedReader(new FileReader(file));   
		String line; 
		  while ((line = br.readLine()) != null) {
			String[] words = line.split(" ");  
			configMap.put(words[0], Integer.valueOf(words[1]));
		  } 
		return configMap;
	}

	@Override
	public LevelDesign generateLevel(Integer levelNumber) throws IOException {
		LevelDesign level = new LevelDesignImpl();
		currentConfig = getLevelConfig(levelNumber);
		int numOfRooms = currentConfig.get("minRooms") + random.nextInt(1 + currentConfig.get("maxRooms") - currentConfig.get("minRooms"));
		for(int i = 0; i < numOfRooms; i++) {
			level.addRoom(generateRoom(levelNumber, i));
		}
		level.addGraph(generateRoomsGraph(level.getRooms()));
		return level;
	}

	private RoomDesign generateRoom(Integer levelNumber, int index) {
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
		return room;
	}
	
	private BidirectionalGraph<RoomDesign> generateRoomsGraph(LinkedList<RoomDesign> rooms) {

		BidirectionalGraph<RoomDesign> graph = new BidirectionalGraph<RoomDesign>();
		
		rooms.forEach( r -> {
			graph.addNode(r);
		});
		
		graph.getNodes().forEach( n -> {
			int numOfRemainingEdges = random.nextInt(GameSettings.MAXDOORS) + GameSettings.MINDOORS; // between 1 and 4 edge
			while(numOfRemainingEdges > 0 && graph.getEdges(n).size() < GameSettings.MAXDOORS ) {
				int randomNodeIndex = random.nextInt(rooms.size());
				if(randomNodeIndex != n.getRoomID() && !graph.getEdges(n).contains(rooms.get(randomNodeIndex))) {
					if(graph.getEdges(rooms.get(randomNodeIndex)).size() < GameSettings.MAXDOORS) {
						graph.addEdge(n, rooms.get(randomNodeIndex));
						numOfRemainingEdges--;
					}
				}
			}
			
		});
		
		return graph;
		
	}
	
}
