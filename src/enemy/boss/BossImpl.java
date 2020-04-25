package enemy.boss;

import design.RoomDesign;
import design.utilities.Pair;
import enemy.EnemyImpl;
import enemy.TypeEnemy;
import enemy.attack.TypeAttack;
import enemy.move.TypeMove;
import utility.Direction;
import enemy.boss.BossDefault;

public class BossImpl extends EnemyImpl implements Boss {

	private RoomDesign room;

	public BossImpl(Pair<Integer, Integer> pos, int damage, int speed, int health, TypeMove move, Direction dir,
			TypeAttack att, RoomDesign room, TypeEnemy mon) {
		super(pos, damage, speed, health, move, dir, att, room, mon);
		this.room = room;
	}

	public BossImpl(Pair<Integer, Integer> pos, RoomDesign room) {
		this(pos, BossDefault.DAMAGE.getValue(), BossDefault.SPEED.getValue(), BossDefault.HEALTH.getValue(),
				TypeMove.RANDOM, Direction.getRandomDir(), TypeAttack.getBossAtt(), room, TypeEnemy.BOSS);
	}

	public boolean isAlive() {
		// room.addEnemy(enemy);
		return super.isAlive();
	}

}
