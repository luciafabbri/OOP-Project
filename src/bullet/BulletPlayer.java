package bullet;

import utility.Debuff;
import utility.Direction;
import design.RoomDesign;
import design.utilities.Pair;
import bullet.move.CheckPlayerBull;

public class BulletPlayer extends BulletImpl {

	public BulletPlayer(Pair<Integer, Integer> position, int damage, Debuff debuff, Direction direction, RoomDesign room) {
		super(position, damage, debuff, direction, room);
	}
	
	public BulletPlayer(Pair<Integer, Integer> position, int damage, Direction direction, RoomDesign room) {
		super(position, damage, Debuff.NO_ONE, direction, room);
	}
	
	public void updatePos() {
		super.updatePos(new CheckPlayerBull(this));
	}

}