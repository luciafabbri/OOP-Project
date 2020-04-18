package design;

import java.util.HashSet;
import java.util.Set;

import design.utilities.BidirectionalGraph;
import design.utilities.Pair;
import gameEntities.Obstacle;
import gameEntities.Stairs;

public interface RoomDesign {
	
	int getRoomID();
	
	void addEnemy(design.tokens.Enemy enemy);
	
	void addObstacle(gameEntities.Obstacle obstacle);
	
	Set<Pair<Integer, Integer>> getOccupiedTiles();
	
	void addOccupiedTile(Pair<Integer, Integer> tile);
	
	Set<design.tokens.Enemy> getEnemySet();
		
	Set<gameEntities.Obstacle> getObstacleSet();
	
	Set<Pair<Integer, Integer>> getObstaclePositions();
	
	BidirectionalGraph<Pair<Integer, Integer>> getTilesGraph();
	
	Stairs getStairs();

	void setStairs(Stairs stairs);
	boolean areStairsPresent();

	void setStairsPresence(boolean stairsPresent);
}
