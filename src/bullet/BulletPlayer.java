package bullet;

import utility.CheckPos;
import utility.Debuff;
import utility.Direction;
import design.RoomDesign;
import design.utilities.Pair;
import bullet.move.CheckMonsBull;

public class BulletPlayer extends BulletImpl {

	private CheckPos check = new CheckMonsBull();

	public BulletPlayer(Pair<Integer, Integer> position, int damage, Debuff debuff, Direction direction, RoomDesign room) {
		super(position, damage, debuff, direction, room);
	}
	
	public BulletPlayer(Pair<Integer, Integer> position, int damage, Direction direction, RoomDesign room) {
		super(position, damage, Debuff.NO_ONE, direction, room);
	}
	
	public void updatePos() {
		super.updatePos(check);
	}

}