package bullet;

import bullet.move.CheckMonsBull;
import utility.CheckPos;
import utility.Debuff;
import utility.Direction;
import design.RoomDesign;
import design.utilities.Pair;

public class BulletMonster extends BulletImpl {
	
	private CheckPos check = new CheckMonsBull();

	public BulletMonster(Pair<Integer, Integer> position, int damage, Debuff debuff, Direction direction, RoomDesign room) {
		super(position, damage, debuff, direction, room);
	}
	
	public BulletMonster(Pair<Integer, Integer> position, int damage, Direction direction, RoomDesign room) {
		this(position, damage, Debuff.NO_ONE, direction, room);
	}
	
	public void updatePos() {
		super.updatePos(check);
	}

}
