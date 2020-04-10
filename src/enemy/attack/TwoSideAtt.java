package enemy.attack;

import utility.Direction;
import utility.Pair;

public class TwoSideAtt implements MonsterAttack {

	@Override
	public void createBullets(Pair<Integer, Integer> pos, Direction dir, int dmg) {
		MonsterAttack bull = new OneSideAtt();
		bull.createBullets(pos, dir, dmg);
		bull.createBullets(pos, findOppDir(dir), dmg);
	}
	
	private Direction findOppDir(Direction dir) {
		Direction direction = null;
		for(Direction d : Direction.values()) {
			if(d.getAbscissa() == findOppValue(dir.getAbscissa()) && d.getOrdinate() == findOppValue(dir.getOrdinate())) {
				direction=d;
			}
		}
		return direction;
	}
	
	private int findOppValue(int value) {
		switch (value) {
		case 1:	
			return -1;
			
		case -1:
			return 1;
			
		case 0: 
			return 0;
		
		default: 
			throw new IllegalArgumentException();
		
		}
	}

}
