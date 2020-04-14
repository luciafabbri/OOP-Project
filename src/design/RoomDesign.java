package design;

import java.util.HashSet;
import java.util.Set;

import design.utilities.BidirectionalGraph;
import design.utilities.Pair;
import gameEntities.Obstacle;

public interface RoomDesign {
	
	int getRoomID();
	
	void addEnemy(design.tokens.Enemy enemy);
	
	void addWorldObject(design.tokens.WorldObject object);
	
	void addObstacle(gameEntities.Obstacle obstacle);
	
	Set<Pair<Integer, Integer>> getOccupiedTiles();
	
	void addOccupiedTile(Pair<Integer, Integer> tile);
	
	Set<design.tokens.Enemy> getEnemySet();

	Set<design.tokens.WorldObject> getWorldObjectsSet();
		
	Set<gameEntities.Obstacle> getObstacleSet();
	
	Set<Pair<Integer, Integer>> getObstaclePositions();
	
	BidirectionalGraph<Pair<Integer, Integer>> getTilesGraph();
}
