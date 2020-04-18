package design.generation;
import java.io.*;
import java.util.*;

import design.*;
import design.utilities.*;
import design.tokens.*;

public class LevelDesignGeneratorImpl implements LevelDesignGenerator {
	
	private Random random = new Random();
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
		int stairsRoomID = setStairsRoom(numOfRooms);
		RoomDesignGenerator roomGen = new RoomDesignGeneratorImpl(currentConfig, stairsRoomID);
		for(int i = 0; i < numOfRooms; i++) {
			level.addRoom(roomGen.generateRoom(i));
		}
		BidirectionalGraph<RoomDesign> graph = graphGen.generateRoomsGraph(level.getRooms());
		graphGen.generateDoorsLayout(graph);
		level.addGraph(graph);
		level.addDoorsLayout(graphGen.generateDoorsLayout(graph));

		return level;
	}

	private int setStairsRoom(int numOfRooms) {
		/* the room that contains the stairs to the next level cannot be room 0,
		 *  it can be any other randomly chosen room */
		return random.nextInt(numOfRooms -1) + 1;
	}

	
	
}
