package design.generation;

import java.util.Map;
import java.util.Random;
import org.newdawn.slick.SlickException;
import design.RoomDesignImpl;
import design.utilities.*;
import design.utilities.graphs.BreadthFirstSearch;

public class RoomDesignGeneratorImpl implements RoomDesignGenerator {

	private final Map<String, Integer> currentConfig;
	private final Random random = new Random();
	private final TilesGraphGenerator graphGen = new TilesGraphGeneratorImpl();
	private final BreadthFirstSearch<Pair<Integer, Integer>> bfs = new BreadthFirstSearch<>();
	private final int specialRoomID;
	private final boolean isFinalLevel;

	public RoomDesignGeneratorImpl(Map<String, Integer> currentConfig, Integer specialRoomID, boolean isFinalLevel) {
		this.specialRoomID = specialRoomID;
		this.currentConfig = currentConfig;
		this.isFinalLevel = isFinalLevel;
	}

	@Override
	public RoomDesignImpl generateRoom(int index) throws SlickException  {

		RoomDesignImpl room = new RoomDesignImpl(index);
		EntitiesGenerator entitiesGen = new EntitiesGeneratorImpl(room, currentConfig);
		if (index == specialRoomID) {
			if(isFinalLevel) {
				entitiesGen.generateBoss();
			} else {
				entitiesGen.generateStairs();
			}
			
		}
		int numOfEnemies = currentConfig.get("minEnemies")
				+ random.nextInt(1 + currentConfig.get("maxEnemies") - currentConfig.get("minEnemies"));
		entitiesGen.generateEnemies(numOfEnemies);
		int obstaclePercentage = currentConfig.get("minObstacles%")
				+ random.nextInt(1 + currentConfig.get("maxObstacles%") - currentConfig.get("minObstacles%"));
		int numOfObstacles;
		if (obstaclePercentage > 0) {
			numOfObstacles = GameSettings.TOTALTILES % obstaclePercentage;
		} else {
			numOfObstacles = 0;
		} 
		entitiesGen.generateObstacles(numOfObstacles);
		int numOfPickupables = currentConfig.get("minObjects") + random.nextInt(1 + currentConfig.get("maxObjects") - currentConfig.get("minObjects"));
		entitiesGen.generatePickupables(numOfPickupables);
		// tiles graph generation
		room.setTilesGraph(graphGen.generateTilesGraph(room));
		// door-to-door path check, if false generate new room
		/*
		while(!bfs.areDoorsConnected(room)) {
			return(this.generateRoom(index));
		}
		*/
		return room;
	}

}
