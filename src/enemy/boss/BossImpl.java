package enemy.boss;

import design.RoomDesign;
import design.utilities.Pair;
import enemy.EnemyImpl;
import enemy.TypeEnemy;
import enemy.attack.TypeAttack;
import enemy.move.TypeMove;
import utility.Direction;

public class BossImpl extends EnemyImpl implements Boss{

	public BossImpl(Pair<Integer, Integer> pos, int damage, int speed, int health, TypeMove move, Direction dir,
			TypeAttack att, RoomDesign room, TypeEnemy mon) {
		super(pos, damage, speed, health, move, dir, att, room, mon);
	}
	
	public BossImpl(Pair<Integer, Integer> pos, int damage, int health,	TypeAttack att, RoomDesign room, TypeEnemy mon) {
		this(pos, damage, getSpeed(mon), health, TypeMove.RANDOM, Direction.getRandomDir(), att, room, mon);
	}
	
	private static int getSpeed(TypeEnemy enemy) {
		return enemy.equals(TypeEnemy.BOSS1) ? 15 : 1;
	}

	public boolean isAlive() {
		if(this.getTypeEnemy().equals(TypeEnemy.BOSS2)) {
			//Aggiungi Mostro
		}
		return super.isAlive();
	}

	
}
