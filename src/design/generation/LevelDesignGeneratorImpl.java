package design.generation;

import java.io.*;
import java.util.*;
import org.newdawn.slick.SlickException;
import design.*;
import design.utilities.graphs.BidirectionalGraph;

/**
 * Implementation of interface LevelDesignGenerator
 *
 */
public class LevelDesignGeneratorImpl implements LevelDesignGenerator {

	private final Random random = new Random();
	private Map<String, Integer> currentConfig = new HashMap<>();
	private final RoomsGraphGenerator graphGen = new RoomsGraphGeneratorImpl();

	/**
	 * Method to retrieve the levels' configuration text files, containing all the
	 * ranges for random generation and other necessary stats. The configMap is
	 * implemented through a Map association.
	 * 
	 * @param levelNumber, the number of the level to be generated, acceptable
	 *                     numbers range from 1 to 4, as the game is made of 4
	 *                     levels
	 * @return the configMap for the required level
	 * @throws IOException
	 */
	private Map<String, Integer> getLevelConfig(Integer levelNumber) throws IOException {
		Map<String, Integer> configMap = new HashMap<>();
		File file = new File("res/levelConfigs/level" + levelNumber + ".txt");
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
		// randomly pick number of rooms between configuration bounds
		final int numOfRooms = currentConfig.get("minRooms")
				+ random.nextInt(1 + currentConfig.get("maxRooms") - currentConfig.get("minRooms"));
		// randomly pick special room ID
		final Integer specialRoomID = setSpecialRoom(numOfRooms);
		// randomly pick coin room ID
		final Integer coinRoomID = random.nextInt(numOfRooms);
		// set whether level is final level
		final boolean isFinalLevel = (levelNumber == 4);
		RoomDesignGenerator roomGen = new RoomDesignGeneratorImpl(currentConfig, specialRoomID, coinRoomID, isFinalLevel);
		for (int i = 0; i < numOfRooms; i++) {
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

	/**
	 * the room that contains the stairs to the next level OR the final boss, is
	 * called special room, it cannot be room 0, it can be any other randomly chosen
	 * room
	 * 
	 * @param numOfRooms, total number of rooms in this level
	 * @return integer corresponding to the special room's ID
	 */
	private int setSpecialRoom(int numOfRooms) {
		return random.nextInt(numOfRooms - 1) + 1;
	}

}
