package entity.move;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import entity.Entity;

/**
 * Class that implements interface CheckPos used to check if an entity is going out of bounds or 
 * is in collision with an obstacles in the current room
 * According to his current direction, new dimensions will be set
 */

public class CheckPosImpl implements CheckPos, GameSettings{
	
	protected int leftPix;
	protected int rightPix;
	protected int downPix;
	protected int upPix;
	private Entity entity;
	
	/**
	 * Default constructor
	 * @param entity, the entity of which we have to check the next available position	 
	 */
	public CheckPosImpl(Entity entity) {
		this.entity = entity;
	}
	
	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		updateDimension();
		return !(isOutOfLimits(pos) || checkObstaclesRoom(room, pos));
	}
	
	/**
	 * Method used to check if an entity is in collision with an obstacle in the dungeon
	 * @param room, entity's current room
	 * @param pos, entity's current position
	 * @return true if the entity had a collision with an obstacle
	 */
	protected boolean checkObstaclesRoom(RoomDesign room, Pair<Integer, Integer> pos) {
		boolean checkX, checkY;
		for (Pair<Integer, Integer> obst : room.getObstaclePositions()) {
			checkX = pos.getX() + leftPix < obst.getX() + GameSettings.TILESIZE && pos.getX() + rightPix > obst.getX() ;
			checkY = pos.getY() + upPix < obst.getY() + TILESIZE  && pos.getY() + downPix > obst.getY();
			if (checkX && checkY) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method used to check if an entity is going out of dungeon's bounds
	 * @param pos, entity's current coordinates 
	 * @return true if the entity is out of bounds
	 */
	private boolean isOutOfLimits(Pair<Integer, Integer> pos) {
		return ((pos.getX() + leftPix < LIMITLEFT || pos.getX() + rightPix > LIMITRIGHT)
				|| (pos.getY() + upPix < LIMITUP || pos.getY() + downPix > LIMITDOWN));
	}

	/**
	 * Method used to update entity's dimensions in the dungeon according to his current direction
	 */
	private void updateDimension() {
		this.upPix = entity.getDimension().getUp();
		this.downPix = entity.getDimension().getDown();
		this.leftPix = entity.getDimension().getLeft();
		this.rightPix = entity.getDimension().getRight();
	}
	
}
