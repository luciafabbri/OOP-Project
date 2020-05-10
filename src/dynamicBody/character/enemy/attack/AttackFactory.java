package dynamicBody.character.enemy.attack;

import dynamicBody.character.enemy.Enemy;
import worldModel.RoomModel;

public class AttackFactory {

	public MonsterAttack selectAttack(TypeAttack typeAttack, RoomModel room, Enemy enemy) {
		switch (typeAttack) {
		case ONE_SIDE:
			return new OneSideAtt(room, enemy);

		case TWO_SIDE:
			return new TwoSideAtt(room, enemy);

		case FOUR_SIDE:
			return new FourSideAtt(room, enemy);

		case TRIPLE:
			return new TripleAtt(room, enemy);

		default:
			throw new IllegalArgumentException("The Attack of the TypeAttack isn't implemented");

		}
	}
}
