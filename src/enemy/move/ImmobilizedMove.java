package enemy.move;

import enemy.Enemy;
import utility.Direction;
import utility.Pair;

public class ImmobilizedMove implements MovePosMonster{

	private Pair<Integer,Integer> posPlayer = new Pair<Integer,Integer>(100,100);
	private Pair<Integer,Integer> posMonster;
	private Direction nextDir;
	
	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, Direction dir) {
		posMonster=pos;
		return pos;
	}

	@Override
	public Direction getDirection() {
		return findDir();
	}
	
	private Direction findDir() {
		int x,y;
		if( posPlayer.getX() >= posMonster.getX() - Enemy.DIMENSION/2 && posPlayer.getX() <= posMonster.getX() + Enemy.DIMENSION/2) {
			x = 0;
		} else if ( posPlayer.getX() > posMonster.getX()) {
			x = -1;
		} else {
			x = 1;
		}
		if( posPlayer.getY() >= posMonster.getY() - Enemy.DIMENSION/2 && posPlayer.getY() <= posMonster.getY() + Enemy.DIMENSION/2) {
			y = 0;
		} else if ( posPlayer.getY() > posMonster.getY()) {
			y = -1;
		} else {
			y = 1;
		}
		for(Direction d : Direction.values()) {
			if(d.getAbscissa() == x && d.getOrdinate() == y) {
				this.nextDir=d;
			}
		}
		return nextDir;
	}

}
