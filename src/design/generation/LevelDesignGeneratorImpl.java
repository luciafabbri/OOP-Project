package design.generation;
import java.io.*;
import java.util.*;

import design.*;
import design.utilities.*;
import design.tokens.*;

public class LevelDesignGeneratorImpl implements LevelDesignGenerator {
	
	private Random random = new Random();
	private RandomPosition randomPosition = new CoherentRandomPosition();
	private Map<String, Integer> currentConfig = new HashMap<>();
	private RoomsGraphGenerator graphGen = new RoomsGraphGeneratorImpl();
	
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
		LevelDesignImpl level = new LevelDesignImpl();
		currentConfig = getLevelConfig(levelNumber);
		int numOfRooms = currentConfig.get("minRooms") + random.nextInt(1 + currentConfig.get("maxRooms") - currentConfig.get("minRooms"));
		for(int i = 0; i < numOfRooms; i++) {
			level.addRoom(generateRoom(levelNumber, i));
		}
		BidirectionalGraph<RoomDesign> graph = graphGen.generateRoomsGraph(level.getRooms());
		graphGen.generateDoorsLayout(graph);
		level.addGraph(graph);
		level.addDoorsLayout(graphGen.generateDoorsLayout(graph));

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

	
}
