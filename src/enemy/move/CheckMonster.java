package enemy.move;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import enemy.Enemy;
import utility.CheckPosDir;
import utility.Direction;

public class CheckMonster implements CheckPosDir, GameSettings {

	private int x, y;
	private Direction newDir;

	@Override
	public Direction changeDir(RoomDesign room, Pair<Integer, Integer> pos, Direction dir) {

		if (pos.getX() + 49 >= LIMITRIGHT) {
			this.x = -dir.getAbscissa();
		} else if (pos.getX() + 15 < LIMITLEFT) {
			this.x = -dir.getAbscissa();
		} else {
			this.x = dir.getAbscissa();
			;
		}

		if (pos.getY() + Enemy.DIMENSION >= LIMITDOWN) {
			this.y = -dir.getOrdinate();
		} else if (pos.getY() + 48 < LIMITUP) {
			this.y = -dir.getOrdinate();
		} else {
			this.y = dir.getOrdinate();
		}

		if (checkObstaclesRoom(room, pos)) {
			for (Pair<Integer, Integer> obst : room.getObstaclePositions()) {
//				System.out.println(obstacleSet.size());
				if (pos.getX() - 16 <= obst.getX() - TILESIZE || pos.getX() + 16 >= obst.getX() + TILESIZE) {
					this.x = -dir.getAbscissa();
				}
				if (pos.getY() <= obst.getY() - TILESIZE || pos.getY() + 48 >= obst.getY() + TILESIZE) {
					this.y = -dir.getOrdinate();
				}
			}
		}

		for (Direction d : Direction.values()) {
			if (d.getAbscissa() == x && d.getOrdinate() == y) {
				this.newDir = d;
			}
		}

		return newDir;
	}

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

	private boolean checkObstaclesRoom(RoomDesign room, Pair<Integer, Integer> pos) {
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
