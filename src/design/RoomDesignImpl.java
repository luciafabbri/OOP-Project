package design;

import java.util.*;
import java.util.stream.Collectors;


import design.utilities.Pair;
import design.utilities.graphs.BidirectionalGraph;
import entity.character.enemy.Enemy;
import gameEntities.*;

public class RoomDesignImpl implements RoomDesign {

	private int roomID;
	private HashSet<Pair<Integer, Integer>> occupiedTiles = new HashSet<>();
	private HashSet<Enemy> enemySet = new HashSet<>();
	private HashSet<Obstacle> obstacleSet = new HashSet<>();
	private HashSet<Pickupable> pickupablesSet = new HashSet<>();
	private BidirectionalGraph<Pair<Integer, Integer>> tilesGraph;
	private boolean stairsPresent = false;
	private Stairs stairs;

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

	public Set<Enemy> getEnemySet() {
		return enemySet;
	}

	public Set<gameEntities.Obstacle> getObstacleSet() {
		return obstacleSet;
	}

	public Set<Pair<Integer, Integer>> getObstaclePositions() {

		return obstacleSet.stream().map(o -> o.getPosition()).collect(Collectors.toSet());

	}

	public Stairs getStairs() {
		if (this.stairsPresent) {
			return stairs;
		} else {
			throw new IllegalStateException();
		}

	}

	public void setStairs(Stairs stairs) {
		if (this.stairsPresent) {
			this.stairs = stairs;
		}

	}

	public boolean areStairsPresent() {
		return stairsPresent;
	}

	public void setStairsPresence(boolean stairsPresent) {
		this.stairsPresent = stairsPresent;
	}

	public void addPickupable(Pickupable pickupable) {
		pickupablesSet.add(pickupable);

	}

	public Set<Pickupable> getPickupablesSet() {
		return pickupablesSet;
	}

}
