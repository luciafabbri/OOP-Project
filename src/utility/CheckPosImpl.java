package utility;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import enemy.Enemy;

public class CheckPosImpl implements CheckPos, GameSettings{

	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		return !(isOutOfLimits(pos) || checkObstaclesRoom(room, pos));
	}

	private boolean isOutOfLimits(Pair<Integer, Integer> pos) {
		// REMINDER: NEED TO CHANGE NUMBERS WHILE CHECKING COORDS BECAUSE MAINCHAR IS
		// DIFFERENT BASED ON DIRECTIONS
		return ((pos.getX() + 15 < LIMITLEFT || pos.getX() + 49 >= LIMITRIGHT)
				|| (pos.getY() + 48 < LIMITUP || pos.getY() + Enemy.DIMENSION >= LIMITDOWN));
	}

	public boolean checkObstaclesRoom(RoomDesign room, Pair<Integer, Integer> pos) {
		boolean checkX, checkY;
		// REMINDER: NEED TO CHANGE NUMBERS WHILE CHECKING COORDS BECAUSE MAINCHAR IS
		// DIFFERENT BASED ON DIRECTIONS
		for (Pair<Integer, Integer> obst : room.getObstaclePositions()) {
			checkX = (pos.getX() - 16 >= obst.getX() - TILESIZE && pos.getX() + 16 <= obst.getX() + TILESIZE);
			checkY = (pos.getY() >= obst.getY() - TILESIZE && pos.getY() + 48 <= obst.getY() + TILESIZE);
//			System.out.println(obstacleSet.size());
			if (checkX && checkY) {
				return true;
			}

		}
		return false;
	}
	

}
