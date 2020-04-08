package design;

import java.util.HashSet;

import design.utilities.Pair;
import gameEntities.Obstacle;

public interface RoomDesign {
	
	int getRoomID();
	
	void addEnemy(design.tokens.Enemy enemy);
	
	void addWorldObject(design.tokens.WorldObject object);
	
	void addObstacle(gameEntities.Obstacle obstacle);
	
	HashSet<Pair<Integer, Integer>> getOccupiedTiles();
	
	void addOccupiedTile(Pair<Integer, Integer> tile);
	
	HashSet<design.tokens.Enemy> getEnemySet();

	HashSet<design.tokens.WorldObject> getWorldObjectsSet();
		
	HashSet<gameEntities.Obstacle> getObstacleSet();
}
