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
	public Direction changeDir(Pair<Integer, Integer> pos, Direction dir) {

		if(pos.getX() >= LIMITRIGHT) {
			this.x = -1;
		} else if (pos.getX() <= LIMITLEFT) {
			this.x = 1;
		} else {
			this.x = dir.getAbscissa();
		}
		
		if(pos.getY() >= LIMITDOWN) {
			
			y = -1;
		} else if (pos.getY() <= LIMITUP) {
			y = 1;
		} else {
			this.y = dir.getOrdinate();
		}
		
		for(Direction d : Direction.values()) {
			if(d.getAbscissa() == x && d.getOrdinate() == y) {
				this.newDir=d;
			}
		}
		
		return newDir;
	}
	
	@Override
	public boolean possiblePos(RoomDesign room, Pair<Integer, Integer> pos) {
		return !isOutOfLimits(pos) || !isOnObstacle(room, pos);
	}
	
	private boolean isOutOfLimits(Pair<Integer,Integer> pos) {
		return (pos.getX() <= LIMITLEFT || pos.getX() + Enemy.DIMENSION >= LIMITLEFT) || 
				(pos.getY() <= LIMITUP || pos.getY() + Enemy.DIMENSION >= LIMITDOWN);
	}
	
	private boolean isOnObstacle(RoomDesign room, Pair<Integer, Integer> pos) {
		boolean checkX;
		boolean checkY;
		Pair<Integer, Integer> pixelSouthWest= pos;
		Pair<Integer, Integer> pixelNorthEast= new Pair<>(pos.getX()+Enemy.DIMENSION,pos.getY());
		Pair<Integer, Integer> pixelNorthWest= new Pair<>(pos.getX()+Enemy.DIMENSION,pos.getY()+Enemy.DIMENSION);
		Pair<Integer, Integer> pixelSouthEast= new Pair<>(pos.getX(),pos.getY()+Enemy.DIMENSION);
		
		
		return false;
	}
		
	

}
