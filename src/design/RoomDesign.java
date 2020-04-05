package design;

import java.util.HashSet;

import gameEntities.Obstacle;
import utilities.Pair;

public interface RoomDesign {
	
	int getRoomID();
	
	void addEnemy(tokens.Enemy enemy);
	
	void addWorldObject(tokens.WorldObject object);
	
	void addObstacle(gameEntities.Obstacle obstacle);
	
	HashSet<Pair<Integer, Integer>> getOccupiedTiles();
	
	void addOccupiedTile(Pair<Integer, Integer> tile);
	
	HashSet<tokens.Enemy> getEnemySet();

	HashSet<tokens.WorldObject> getWorldObjectsSet();
		
	HashSet<gameEntities.Obstacle> getObstacleSet();
}
