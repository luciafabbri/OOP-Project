package bullet;

import utility.CheckPos;
import utility.Debuff;
import utility.Direction;
import utility.Pair;
import bullet.move.checkMonsBull;
import enemy.TypeMove;

public class BulletPlayer extends BulletImpl {

	private CheckPos check = new checkMonsBull();

	BulletPlayer(Pair<Integer, Integer> position, int damage, Debuff debuff, Direction direction, TypeMove typeMove) {
		super(position, damage, debuff, direction, typeMove);
	}
	
	public void updatePos() {
		super.updatePos(check);
		
	}

}
