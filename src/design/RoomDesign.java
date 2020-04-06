package design;

import java.util.HashSet;

import designUtilities.Pair;
import gameEntities.Obstacle;

public interface RoomDesign {
	
	int getRoomID();
	
	void addEnemy(designTokens.Enemy enemy);
	
	void addWorldObject(designTokens.WorldObject object);
	
	void addObstacle(gameEntities.Obstacle obstacle);
	
	HashSet<Pair<Integer, Integer>> getOccupiedTiles();
	
	void addOccupiedTile(Pair<Integer, Integer> tile);
	
	HashSet<designTokens.Enemy> getEnemySet();

	HashSet<designTokens.WorldObject> getWorldObjectsSet();
		
	HashSet<gameEntities.Obstacle> getObstacleSet();
}
