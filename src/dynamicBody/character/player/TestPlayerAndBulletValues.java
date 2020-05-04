package dynamicBody.character.player;

import static org.junit.Assert.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.SlickException;

import design.RoomDesign;
import design.RoomDesignImpl;
import design.utilities.Pair;
import design.utilities.enums.Entities;
import dynamicBody.bullet.Bullet;
import dynamicBody.bullet.BulletPlayerImpl;
import dynamicBody.move.Direction;

/**
 * JUnit test for player's and bullet's initial functionalities
 */

public class TestPlayerAndBulletValues {

	private static Player testPlayer;
	private static Bullet testBullet;
	private static RoomDesign testRoom;
	
	@org.junit.BeforeClass
	public static void initTest() {
		try {
			// display.create is needed because default constructor of bulletPlayerImpl contains an Image 
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testRoom = new RoomDesignImpl(1);
		testPlayer = new PlayerImpl(new Pair<Integer,Integer>(64, 64), Direction.SOUTH, 0);
		testBullet = new BulletPlayerImpl(testPlayer.getPosition(), testPlayer.getDamage(), testPlayer.getDirection(), testRoom);
	}

	/**
	 * To check initial player's conditions  
	 * @throws SlickException 
	 */
	@org.junit.Test
	public void testStartPlayer() throws SlickException {	
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
		assertEquals(testPlayer.getRoom(), null);
	}
	
	/**
	 * To check initial bullet's conditions  
	 */
	@org.junit.Test
	public void testBulletPlayer() {		
		assertTrue(testBullet.isAlive());
		assertEquals(testBullet.getDamage(), 10);
		assertEquals(testBullet.getPos(), new Pair<>(64,64));
		assertEquals(testBullet.getDirection(), Direction.SOUTH);
		assertEquals(testBullet.getRoom(), testRoom);
	} 

}
