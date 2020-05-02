package dynamicBody.character.player;

import static org.junit.Assert.*;
import org.newdawn.slick.Input;
import design.utilities.Pair;
import dynamicBody.bullet.Bullet;
import dynamicBody.bullet.BulletPlayerImpl;
import dynamicBody.move.Direction;

/**
 * JUnit test for player's functionalities
 */

public class TestPlayer {

	private Player testPlayer;
	private Bullet testBullet;
	private Input input;
	
	@org.junit.Before
	public void initTest() {
		
		testPlayer = new PlayerImpl(new Pair<Integer,Integer>(64, 64), Direction.SOUTH, 0);
		testBullet = new BulletPlayerImpl(testPlayer.getPosition(), testPlayer.getDamage(),testPlayer.getDirection(), testPlayer.getRoom());  	

	}
	
	/**
	 * To check initial player's conditions  
	 */
	@org.junit.Test
	public void testStartPlayer() {
		assertTrue(testPlayer.isAlive());
		assertEquals(testPlayer.getHealth().getMaxHealth(), 100);
		assertEquals(testPlayer.getPosition(), new Pair<>(64,64));
		assertEquals(testPlayer.getDirection(), Direction.SOUTH);
		assertEquals(testPlayer.getDamage(), 10);
		assertEquals(testPlayer.getLevel(), 0);		
		assertEquals(testPlayer.getInventory().getCoin(), 0);		
		assertEquals(testPlayer.getInventory().getKey(), 0);	
		assertEquals(testPlayer.getPlayerSpeed(), 1);		
		assertEquals(testPlayer.getRateOfFire(), 1000);		
	}
	
	/**
	 * To check initial bullet's conditions  
	 */
	@org.junit.Test
	public void testBulletPlayer() {
		assertTrue(testBullet.isAlive());
		assertEquals(testBullet.getDamage(), testPlayer.getDamage());
		assertEquals(testBullet.getPos(), testPlayer.getPosition());
		assertEquals(testBullet.getRoom(), testPlayer.getRoom() );
		assertEquals(testBullet.getDirection(), testPlayer.getDirection());
	}
	
	/**
	 * To check if the player moves rightly after user's command from the keyboard (button a, w , d, s)
	 */
	@org.junit.Test
	public void testMovePlayer() {
		assertTrue(input.isKeyDown(Input.KEY_A));
		assertTrue(input.isKeyDown(Input.KEY_W));
		assertTrue(input.isKeyDown(Input.KEY_D));
		assertTrue(input.isKeyDown(Input.KEY_S));

		//	this.player.getMove().movePlayer( input.isKeyDown(Input.KEY_W), player.getPosition(), player.getDirection(), player.getPlayerSpeed());
		//	this.player.getMove().movePlayer( input.isKeyDown(Input.KEY_D), player.getPosition(), player.getDirection(), player.getPlayerSpeed());
		//	this.player.getMove().movePlayer( input.isKeyDown(Input.KEY_S), player.getPosition(), player.getDirection(), player.getPlayerSpeed());
	}
	
	/**
	 * To check if the player shoot rightly after user's command from the keyboard (space bar)
	 */
	@org.junit.Test
	public void testShootPlayer() {
		assertTrue(input.isKeyPressed(Input.KEY_SPACE));
		assertTrue(testBullet.isAlive());
	}

}
