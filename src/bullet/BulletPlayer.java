package bullet;

import utility.CheckPos;
import utility.Debuff;
import utility.Direction;
import design.utilities.Pair;
import bullet.move.CheckMonsBull;
import enemy.TypeMove;

public class BulletPlayer extends BulletImpl {

	private CheckPos check = new CheckMonsBull();

	BulletPlayer(Pair<Integer, Integer> position, int damage, Debuff debuff, Direction direction, TypeMove typeMove) {
		super(position, damage, debuff, direction, typeMove);
	}
	
	public void updatePos() {
		super.updatePos(check);
		
	}

}
