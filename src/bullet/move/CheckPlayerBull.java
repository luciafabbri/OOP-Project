package bullet.move;

import java.util.Set;

import bullet.Bullet;
import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import utility.CheckPos;
import utility.Direction;

public class CheckPlayerBull implements CheckPos, GameSettings { 

	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		return !isOutOfLimits(pos) || !checkObstacle(room,pos) || !checkEnemyHit(room,pos);
	}
	
	private boolean isOutOfLimits(Pair<Integer, Integer> pos) {
		return (pos.getX() <= LIMITLEFT || pos.getX() + Bullet.DIMENSION >= LIMITRIGHT) || 
				(pos.getY() <= LIMITUP || pos.getY() + Bullet.DIMENSION >= LIMITDOWN);
	}
	
	private boolean checkObstacle(RoomDesign room, Pair<Integer, Integer> pos) {
		Set<Pair<Integer, Integer>> obstacleSet = room.getObstaclePositions();	
		for (Pair<Integer,Integer> obst : obstacleSet) {
			if (obst.equals(pos)) {
				return false;
			}
		}
		return true;
	}
	
	//DA SISTEMARE 
	private boolean checkEnemyHit(RoomDesign room, Pair<Integer, Integer> pos) {
		Set<design.tokens.Enemy> enemySet = room.getEnemySet();
		return false;
	}
}