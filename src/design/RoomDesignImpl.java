package design;

import java.util.*;
import java.util.stream.Collectors;

import design.tokens.*;
import design.utilities.BidirectionalGraph;
import design.utilities.Pair;

public class RoomDesignImpl implements RoomDesign {

	private int roomID;
	private HashSet<Pair<Integer, Integer>> occupiedTiles = new HashSet<>();
	private HashSet<design.tokens.Enemy> enemySet = new HashSet<>();
	private HashSet<design.tokens.WorldObject> worldObjectsSet = new HashSet<>();
	private HashSet<gameEntities.Obstacle> obstacleSet = new HashSet<>();
	private BidirectionalGraph<Pair<Integer, Integer>> tilesGraph;
	
	public RoomDesignImpl(int roomID) {
		this.roomID = roomID;
	}

	public BidirectionalGraph<Pair<Integer, Integer>> getTilesGraph() {
		return tilesGraph;
	}

	public void setTilesGraph(BidirectionalGraph<Pair<Integer, Integer>> tilesGraph) {
		this.tilesGraph = tilesGraph;
	}

	public void addEnemy(Enemy enemy) {
		enemySet.add(enemy);
	}

	public void addWorldObject(WorldObject object) {
		worldObjectsSet.add(object);
		
	}

	@Override
	public int getRoomID() {
		return this.roomID;
	}
	
	public HashSet<Pair<Integer, Integer>> getOccupiedTiles() {
		return this.occupiedTiles;
	}

	@Override
	public void addObstacle(gameEntities.Obstacle obstacle) {
		obstacleSet.add(obstacle);
		
	}

	@Override
	public void addOccupiedTile(Pair<Integer, Integer> tile) {
		occupiedTiles.add(tile);
		
	}

	public Set<design.tokens.Enemy> getEnemySet() {
		return enemySet;
	}

	public Set<design.tokens.WorldObject> getWorldObjectsSet() {
		return worldObjectsSet;
	}

	public Set<gameEntities.Obstacle> getObstacleSet() {
		return obstacleSet;
	}
	
	public Set<Pair<Integer, Integer>> getObstaclePositions() {
		
		return obstacleSet.stream().map(o -> o.getPosition()).collect(Collectors.toSet());
		
	}

}
