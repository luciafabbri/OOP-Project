package design;

import java.util.HashSet;

import design.utils.Pair;
import gameEntities.Obstacle;

public interface RoomDesign {
	
	int getRoomID();
	
	void addEnemy(design.Tokens.Enemy enemy);
	
	void addWorldObject(design.Tokens.WorldObject object);
	
	void addObstacle(gameEntities.Obstacle obstacle);
	
	HashSet<Pair<Integer, Integer>> getOccupiedTiles();
	
	void addOccupiedTile(Pair<Integer, Integer> tile);
	
	HashSet<design.Tokens.Enemy> getEnemySet();

	HashSet<design.Tokens.WorldObject> getWorldObjectsSet();
		
	HashSet<gameEntities.Obstacle> getObstacleSet();
}
