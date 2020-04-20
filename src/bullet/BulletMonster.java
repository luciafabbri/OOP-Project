package bullet;

import bullet.move.CheckMonsBull;
import utility.Debuff;
import utility.Direction;
import design.RoomDesign;
import design.utilities.Pair;

public class BulletMonster extends BulletImpl {
	
	

	public BulletMonster(Pair<Integer, Integer> position, int damage, int speed, Debuff debuff, Direction direction, RoomDesign room) {
		super(position, damage, speed, debuff, direction, room);
	}
	
	public BulletMonster(Pair<Integer, Integer> position, int damage, Direction direction, RoomDesign room) {
		this(position, damage, 1, Debuff.NO_ONE, direction, room);
	}
	
	public void updatePos() {
		super.updatePos(new CheckMonsBull(this));
	}

}
