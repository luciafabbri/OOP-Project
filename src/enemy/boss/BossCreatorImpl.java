package enemy.boss;

import design.RoomDesign;
import design.utilities.Pair;
import enemy.TypeEnemy;
import enemy.attack.TypeAttack;
import enemy.move.TypeMove;
import utility.Direction;

public class BossCreatorImpl implements BossCreator{

	@Override
	public Boss getBossA(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room) {
		return new BossImpl(pos, damage, 15, health, TypeMove.RANDOM, Direction.getRandomDir(), TypeAttack.ONE_SIDE, room, TypeEnemy.BOSS1);
		//VELOCITA' DA METTERE NEL COSTRUTTORE
	}

	@Override
	public Boss getBossB(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room) {
		return new BossImpl(pos, damage, 1, health, TypeMove.RANDOM, Direction.getRandomDir(), TypeAttack.ONE_SIDE, room, TypeEnemy.BOSS2);
	}

	@Override
	public Boss getBossC(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room) {
		return new BossImpl(pos, damage, 1, health, TypeMove.RANDOM, Direction.getRandomDir(), TypeAttack.ONE_SIDE, room, TypeEnemy.BOSS3);
	}

	@Override
	public Boss getBossD(Pair<Integer, Integer> pos, int damage, int health, RoomDesign room) {
		return new BossImpl(pos, damage, 1, health, TypeMove.RANDOM, Direction.getRandomDir(), TypeAttack.ONE_SIDE, room, TypeEnemy.BOSS4);
	}

}
