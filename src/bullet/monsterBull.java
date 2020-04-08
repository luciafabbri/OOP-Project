package bullet;

import bullet.move.checkMonsBull;
import enemy.TypeMove;
import utility.CheckPos;
import utility.Debuff;
import utility.Direction;
import utility.Pair;

public class monsterBull extends BulletImpl {
	
	private CheckPos check = new checkMonsBull();

	monsterBull(Pair<Integer, Integer> position, int damage, Debuff debuff, Direction direction, TypeMove typeMove) {
		super(position, damage, debuff, direction, typeMove);
	}
	
	public void updatePos() {
		super.updatePos(check);
		
	}

}
