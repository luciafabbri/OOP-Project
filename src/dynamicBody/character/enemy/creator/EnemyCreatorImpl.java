package dynamicBody.character.enemy.creator;

import design.RoomDesign;
import design.utilities.Pair;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.character.enemy.EnemyImpl;
import dynamicBody.character.enemy.attack.TypeAttack;
import dynamicBody.character.enemy.boss.BossImpl;
import dynamicBody.character.enemy.move.TypeMove;

/**
 * Class that implements interface EnemyCreator
 */
public class EnemyCreatorImpl implements EnemyCreator {

	@Override
	public Enemy getMonsterA(Pair<Integer, Integer> pos, int health, int damage, RoomDesign room) {
		return new EnemyImpl(pos, damage, health, TypeMove.STRAIGHT, TypeAttack.ONE_SIDE, room, TypeEnemy.MONSTER1);
	}

	@Override
	public Enemy getMonsterB(Pair<Integer, Integer> pos, int health, int damage, RoomDesign room) {
		return new EnemyImpl(pos, damage, health, TypeMove.TELEPORT, TypeAttack.TWO_SIDE, room, TypeEnemy.MONSTER2);
	}

	@Override
	public Enemy getMonsterC(Pair<Integer, Integer> pos, int health, int damage, RoomDesign room) {
		return new EnemyImpl(pos, damage, health, TypeMove.RANDOM, TypeAttack.TRIPLE, room, TypeEnemy.MONSTER3);
	}

	@Override
	public Enemy getMonsterD(Pair<Integer, Integer> pos, int health, int damage, RoomDesign room) {
		return new EnemyImpl(pos, damage, health, TypeMove.IMMOBILIZED, TypeAttack.FOUR_SIDE, room, TypeEnemy.PLANT);
	}

	@Override
	public Enemy getBossA(Pair<Integer, Integer> pos, RoomDesign room) {
		return new BossImpl(pos, room);
	}

}
