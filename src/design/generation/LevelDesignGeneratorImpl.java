package design.generation;
import java.io.*;
import java.util.*;

import org.newdawn.slick.SlickException;
import design.*;
import design.utilities.graphs.BidirectionalGraph;

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
		final int numOfRooms = currentConfig.get("minRooms") + random.nextInt(1 + currentConfig.get("maxRooms") - currentConfig.get("minRooms"));
		final Integer specialRoomID = setSpecialRoom(numOfRooms);
		final boolean isFinalLevel = (levelNumber == 4);
		RoomDesignGenerator roomGen = new RoomDesignGeneratorImpl(currentConfig, specialRoomID, isFinalLevel);
		for(int i = 0; i < numOfRooms; i++) {
			try {
				level.addRoom(roomGen.generateRoom(i));
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
		BidirectionalGraph<RoomDesign> graph = graphGen.generateRoomsGraph(level.getRooms());
		graphGen.generateDoorsLayout(graph);
		level.addGraph(graph);
		level.addDoorsLayout(graphGen.generateDoorsLayout(graph));

		return level;
	}

	private int setSpecialRoom(int numOfRooms) {
		/* the room that contains the stairs to the next level OR the final boss, is called
		 *  special room, it cannot be room 0,
		 *  it can be any other randomly chosen room */
		return random.nextInt(numOfRooms - 1) + 1;
	}

	
	
}
