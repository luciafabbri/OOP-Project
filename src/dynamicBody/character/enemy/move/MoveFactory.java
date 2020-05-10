package dynamicBody.character.enemy.move;

import dynamicBody.character.enemy.Enemy;
import worldModel.RoomModel;

public class MoveFactory {
	
	public MovePosMonster selectMove(TypeMove typeMove, RoomModel room, Enemy enemy) {
		switch (typeMove) {
		case STRAIGHT:
			return new StraightMove(room, enemy);

		case TELEPORT:
			return new TeleportMove(room, enemy);

		case RANDOM:
			return new RandomMove(room, enemy);

		case IMMOBILIZED:
			return new ImmobilizedMove();

		case TO_PLAYER:
			return new ToPlayerMove(room, enemy);

		default:
			throw new IllegalArgumentException("The Movemenet of the TypeMove isn't implemented");

		}
	}

}
