package bullet;

import utility.Debuff;
import utility.Direction;
import utility.Pair;

public class BulletPlayer extends BulletImpl {

	BulletPlayer(Pair<Integer, Integer> position, int damage, Debuff debuff, Direction direction) {
		super(position, damage, debuff, direction);
	}

}
