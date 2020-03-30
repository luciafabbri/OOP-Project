package design;
import java.io.*;
import java.util.*;

import tokens.Enemy;
import tokens.Obstacle;

public class LevelDesignGeneratorImpl implements LevelDesignGenerator {
	
	Random random = new Random();
	Map<String, Integer> currentConfig = new HashMap<>();
	
	private Map<String, Integer> getLevelConfig(Integer levelNumber) throws IOException {
		Map<String, Integer> configMap = new HashMap<>();
		File file = new File("res/level"+ levelNumber + ".txt" );   
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
		return level;
	}

	@Override
	public RoomDesign generateRoom(Integer levelNumber, int i) {
		RoomDesign room = new RoomDesignImpl(i);
		int numOfEnemies = currentConfig.get("minEnemies") + random.nextInt(1 + currentConfig.get("maxEnemies") - currentConfig.get("minEnemies"));
		for(int j = 0; j < numOfEnemies; j++) {
			room.addEnemy(new Enemy());
		}
		int numOfObstacles = currentConfig.get("minObstacles%") + random.nextInt(1 + currentConfig.get("maxObstacles%") - currentConfig.get("minObstacles%"));
		for(int k = 0; k < numOfObstacles; k++) {
			room.addObstacle(new Obstacle());
		}
		return room;
	}

}
