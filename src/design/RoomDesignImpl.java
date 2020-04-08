package design;

import java.util.*;

import design.Tokens.*;
import design.utils.Pair;

public class RoomDesignImpl implements RoomDesign {

	private int roomID;
	private HashSet<Pair<Integer, Integer>> occupiedTiles = new HashSet<>();
	private HashSet<design.Tokens.Enemy> enemySet = new HashSet<>();
	private HashSet<design.Tokens.WorldObject> worldObjectsSet = new HashSet<>();
	private HashSet<gameEntities.Obstacle> obstacleSet = new HashSet<>();
	
	public RoomDesignImpl(int roomID) {
		this.roomID = roomID;
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

	public HashSet<design.Tokens.Enemy> getEnemySet() {
		return enemySet;
	}

	public HashSet<design.Tokens.WorldObject> getWorldObjectsSet() {
		return worldObjectsSet;
	}

	public HashSet<gameEntities.Obstacle> getObstacleSet() {
		return obstacleSet;
	}

}
