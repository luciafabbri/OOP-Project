package design;

import java.util.Set;
import design.utilities.Pair;
import design.utilities.graphs.BidirectionalGraph;
import enemy.Enemy;
import gameEntities.Obstacle;
import gameEntities.Pickupable;
import gameEntities.Stairs;

public interface RoomDesign {
	
	int getRoomID();
	
	void addEnemy(Enemy enemy);
	
	void addObstacle(gameEntities.Obstacle obstacle);
	
	Set<Pair<Integer, Integer>> getOccupiedTiles();
	
	void addOccupiedTile(Pair<Integer, Integer> tile);
	
	Set<Enemy> getEnemySet();
		
	Set<Obstacle> getObstacleSet();
	
	Set<Pair<Integer, Integer>> getObstaclePositions();
	
	BidirectionalGraph<Pair<Integer, Integer>> getTilesGraph();
	
	Stairs getStairs();

	void setStairs(Stairs stairs);
	
	boolean areStairsPresent();

	void setStairsPresence(boolean stairsPresent);
	
	void addPickupable(Pickupable pickupable);

	Set<Pickupable> getPickupablesSet();
}
