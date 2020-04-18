package utility;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import enemy.Enemy;
import player.Player;
import player.PlayerImpl;

public class CheckPosImpl implements CheckPos, GameSettings{
	
	private int leftPix;
	private int rightPix;
	private int downPix;
	private int upPix;
	private Entity entity;
	
	public CheckPosImpl(Entity entity) {
		this.entity = entity;
	}
	

	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		updateDimension();
		return !(isOutOfLimits(pos) || checkObstaclesRoom(room, pos));
	}

	private boolean isOutOfLimits(Pair<Integer, Integer> pos) {
		// REMINDER: NEED TO CHANGE NUMBERS WHILE CHECKING COORDS BECAUSE MAINCHAR IS
		// DIFFERENT BASED ON DIRECTIONS
		return ((pos.getX() + leftPix < LIMITLEFT || pos.getX() + rightPix >= LIMITRIGHT)
				|| (pos.getY() + upPix < LIMITUP || pos.getY() + downPix >= LIMITDOWN));
	}

	public boolean checkObstaclesRoom(RoomDesign room, Pair<Integer, Integer> pos) {
		boolean checkX, checkY;
		// REMINDER: NEED TO CHANGE NUMBERS WHILE CHECKING COORDS BECAUSE MAINCHAR IS
		// DIFFERENT BASED ON DIRECTIONS
		for (Pair<Integer, Integer> obst : room.getObstaclePositions()) {
			checkX = pos.getX() + leftPix < obst.getX() + GameSettings.TILESIZE && pos.getX() + rightPix > obst.getX() ;
			checkY = pos.getY() < obst.getY() + (TILESIZE - rightPix) && pos.getY() + downPix > obst.getY();
//			System.out.println(obstacleSet.size());
			if (checkX && checkY) {
				return true;
			}

		}
		return false;
	}
	
	private void updateDimension() {
		this.upPix = entity.getDimension().getUp();
		this.downPix = entity.getDimension().getDown();
		this.leftPix = entity.getDimension().getLeft();
		this.rightPix = entity.getDimension().getRight();
	}
	

}
