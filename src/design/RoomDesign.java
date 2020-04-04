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
	
}
