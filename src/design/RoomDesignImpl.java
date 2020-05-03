package design;

import java.util.*;
import java.util.stream.Collectors;

import design.utilities.Pair;
import design.utilities.graphs.BidirectionalGraph;
import dynamicBody.character.enemy.Enemy;
import gameEntities.*;

/**
 * Implementation of RoomDesign Interface
 *
 */
public class RoomDesignImpl implements RoomDesign {

	private int roomID;
	private HashSet<Pair<Integer, Integer>> occupiedTiles = new HashSet<>();
	private HashSet<Enemy> enemySet = new HashSet<>();
	private HashSet<Obstacle> obstacleSet = new HashSet<>();
	private HashSet<Pickupable> pickupablesSet = new HashSet<>();
	private BidirectionalGraph<Pair<Integer, Integer>> tilesGraph;
	private boolean stairsPresent = false;
	private Stairs stairs;

	/**
	 * Constructor for a RoomDesignImpl object
	 * 
	 * @param roomID, the integer that identifies a room within a game level
	 */
	public RoomDesignImpl(int roomID) {
		this.roomID = roomID;
	}

	@Override
	public int getRoomID() {
		return this.roomID;
	}

	@Override
	public void addEnemy(Enemy enemy) {
		enemySet.add(enemy);
	}

	@Override
	public void addObstacle(Obstacle obstacle) {
		obstacleSet.add(obstacle);

	}

	@Override
	public void addPickupable(Pickupable pickupable) {
		pickupablesSet.add(pickupable);

	}

	@Override
	public boolean areStairsPresent() {
		return stairsPresent;
	}

	@Override
	public BidirectionalGraph<Pair<Integer, Integer>> getTilesGraph() {
		return tilesGraph;
	}

	@Override
	public Set<Pair<Integer, Integer>> getOccupiedTiles() {
		return this.occupiedTiles;
	}

	@Override
	public Set<Enemy> getEnemySet() {
		return enemySet;
	}

	@Override
	public Set<Obstacle> getObstacleSet() {
		return obstacleSet;
	}

	@Override
	public Set<Pair<Integer, Integer>> getObstaclePositions() {

		return obstacleSet.stream().map(o -> o.getPosition()).collect(Collectors.toSet());

	}

	@Override
	public Set<Pickupable> getPickupablesSet() {
		return pickupablesSet;
	}

	/**
	 * @param occupied tile
	 */
	public void addOccupiedTile(Pair<Integer, Integer> tile) {
		occupiedTiles.add(tile);

	}

	/**
	 * @param tilesGraph for this room, a bidirectional graph that maps a room's
	 *                   tiles and their connections
	 */
	public void setTilesGraph(BidirectionalGraph<Pair<Integer, Integer>> tilesGraph) {
		this.tilesGraph = tilesGraph;
	}

	@Override
	public Stairs getStairs() {
		if (this.stairsPresent) {
			return stairs;
		} else {
			throw new IllegalStateException();
		}

	}

	/**
	 * @param stairs to be added to the room
	 */
	public void setStairs(Stairs stairs) {
		if (this.stairsPresent) {
			this.stairs = stairs;
		}

	}

	/**
	 * @param stairsPresent
	 */
	public void setStairsPresence(boolean stairsPresent) {
		this.stairsPresent = stairsPresent;
	}

}
