package design;

import java.util.*;

import tokens.*;

public class RoomDesignImpl implements RoomDesign {

	private int roomID;
	HashSet<tokens.Enemy> enemySet = new HashSet<>();
	HashSet<tokens.WorldObject> worldObjectsSet = new HashSet<>();
	HashSet<tokens.Obstacle> obstacleSet = new HashSet<>();
	
	public RoomDesignImpl(int roomID) {
		this.roomID = roomID;
	}

	public void addEnemy(Enemy enemy) {
		enemySet.add(enemy);
	}

	public void addWorldObject(WorldObject object) {
		worldObjectsSet.add(object);
		
	}

	public void addObstacle(Obstacle obstacle) {
		obstacleSet.add(obstacle);
		
	}

	@Override
	public int getRoomID() {
		return this.roomID;
	}

}
