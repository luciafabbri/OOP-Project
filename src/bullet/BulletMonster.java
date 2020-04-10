package bullet;

import bullet.move.CheckMonsBull;
import enemy.TypeMove;
import utility.CheckPos;
import utility.Debuff;
import utility.Direction;
import utility.Pair;

public class BulletMonster extends BulletImpl {
	
	private CheckPos check = new CheckMonsBull();

	public BulletMonster(Pair<Integer, Integer> position, int damage, Debuff debuff, Direction direction, TypeMove typeMove) {
		super(position, damage, debuff, direction, typeMove);
	}
	
	public BulletMonster(Pair<Integer, Integer> position, int damage, Direction direction) {
		this(position, damage, Debuff.NO_ONE, direction, TypeMove.STRAIGHT);
	}
	
	public void updatePos() {
		super.updatePos(check);
		
	}

}
