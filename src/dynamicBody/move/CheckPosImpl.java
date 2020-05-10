package dynamicBody.move;

import dynamicBody.DynamicBody;
import worldModel.RoomModel;
import worldModel.utilities.GameSettings;
import worldModel.utilities.Pair;

/**
 * Class that implements interface CheckPos used to check if a dynamic body is going out of bounds or 
 * is in collision with an obstacles in the current room
 * According to his current direction, new dimensions will be set
 */

public class CheckPosImpl implements CheckPos, GameSettings{
	
	protected int leftPix;
	protected int rightPix;
	protected int downPix;
	protected int upPix;
	private DynamicBody entity;
	
	/**
	 * Default constructor
	 * @param entity, the dynamic body's of which we have to check the next available position	 
	 */
	public CheckPosImpl(DynamicBody entity) {
		this.entity = entity;
	}
	
	@Override
	public boolean possiblePos(RoomModel room, Pair<Integer, Integer> pos) {
		updateDimension();
		return !(isOutOfLimits(pos) || checkObstaclesRoom(room, pos));
	}
	
	/**
	 * Method used to check if a dynamic body is in collision with an obstacle in the dungeon
	 * @param room, dynamic body's current room
	 * @param pos, dynamic body's current position
	 * @return true if the dynamic body had a collision with an obstacle
	 */
	protected boolean checkObstaclesRoom(RoomModel room, Pair<Integer, Integer> pos) {
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
	 * Method used to check if a dynamic body's is going out of dungeon's bounds
	 * @param pos, dynamic body's current coordinates 
	 * @return true if the dynamic body is out of bounds
	 */
	private boolean isOutOfLimits(Pair<Integer, Integer> pos) {
		return ((pos.getX() + leftPix < LIMITLEFT || pos.getX() + rightPix > LIMITRIGHT)
				|| (pos.getY() + upPix < LIMITUP || pos.getY() + downPix > LIMITDOWN));
	}

	/**
	 * Method used to update dynamic body's dimensions in the dungeon according to his current direction
	 */
	private void updateDimension() {
		this.upPix = entity.getDimension().getUp();
		this.downPix = entity.getDimension().getDown();
		this.leftPix = entity.getDimension().getLeft();
		this.rightPix = entity.getDimension().getRight();
	}
	
}
