package dynamicBody.character.enemy.move.check;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import dynamicBody.character.Character;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.move.CheckPosImpl;
import dynamicBody.move.Direction;

public class CheckMonsterImpl extends CheckPosImpl implements CheckMonster, GameSettings {

	public CheckMonsterImpl(Character character) {
		super(character);
	}

	private int x, y;
	private Direction newDir;

	@Override
	public Direction changeDir(RoomDesign room, Pair<Integer, Integer> pos, Direction dir) {

		if (pos.getX() + rightPix > LIMITRIGHT) {
			this.x = -dir.getAbscissa();
		} else if (pos.getX() + leftPix < LIMITLEFT) {
			this.x = -dir.getAbscissa();
		} else {
			this.x = dir.getAbscissa();
		}

		if (pos.getY() + downPix > LIMITDOWN) {
			this.y = -dir.getOrdinate();
		} else if (pos.getY() + upPix < LIMITUP) {
			this.y = -dir.getOrdinate();
		} else {
			this.y = dir.getOrdinate();
		}

		if (checkObstaclesRoom(room, pos)) {
			for (Pair<Integer, Integer> obst : room.getObstaclePositions()) {
//				System.out.println(obstacleSet.size());
				if ( pos.getX() + leftPix < obst.getX() + GameSettings.TILESIZE || pos.getX() + rightPix > obst.getX()) {
					this.x = -dir.getAbscissa();
				}
				if (pos.getY() < obst.getY() + (TILESIZE - upPix) || pos.getY() + downPix > obst.getY()) {
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

	

}
