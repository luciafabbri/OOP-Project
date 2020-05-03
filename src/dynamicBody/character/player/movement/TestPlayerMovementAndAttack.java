package dynamicBody.character.player.movement;

import static org.junit.Assert.*;
import design.utilities.Pair;
import dynamicBody.character.player.Player;
import dynamicBody.character.player.PlayerImpl;
import dynamicBody.move.Direction;

public class TestPlayerMovementAndAttack {

	private Player testPlayer;

	@org.junit.Before
	public void initTest() {
		testPlayer = new PlayerImpl(new Pair<Integer,Integer>(64, 64), Direction.SOUTH, 0);
	}
	
	@org.junit.Before
	public void testMovement() {
		assertTrue(testPlayer.isAlive());
	}

}
