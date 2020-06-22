package main.dynamicBody.character.enemy.move;

/**
 * Enumeration of the type of movement that enemy can do
 */
public enum TypeMove {

	STRAIGHT, IMMOBILIZED, TELEPORT, RANDOM, TO_PLAYER;

	public static TypeMove getBossMove() {
		return TO_PLAYER;
	}
}
