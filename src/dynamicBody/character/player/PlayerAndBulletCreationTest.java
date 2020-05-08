package dynamicBody.character.player;

import static org.junit.Assert.*;

import java.io.IOException;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.SlickException;
import design.RoomDesign;
import design.utilities.Pair;
import dynamicBody.bullet.Bullet;
import dynamicBody.bullet.BulletPlayerImpl;
import dynamicBody.move.Direction;
import levels.Level;
import levels.LevelImpl;

/**
 * JUnit test for player's and bullet's initial functionalities
 */

public class PlayerAndBulletCreationTest {

	private static Player testPlayer;
	private static Bullet testBullet;
	private static RoomDesign testRoom;
	private static Level testLevel; 
	
	@org.junit.BeforeClass
	public static void initTest() throws IOException {
		try {
			// display.create is needed because default constructor of bulletPlayerImpl contains an Image 
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		testLevel = new LevelImpl(1); 
		testRoom = testLevel.getLevel().get(0).getRoom();
		testPlayer = new PlayerImpl(new Pair<Integer,Integer>(64, 64), Direction.SOUTH, testRoom.getRoomID());
		testPlayer.setCurrentRoom(testRoom);
		testBullet = new BulletPlayerImpl(testPlayer.getPosition(), testPlayer.getDamage(), testPlayer.getDirection(), testPlayer.getRoom());
	}

	/**
	 * To check initial player's conditions  
	 * @throws SlickException 
	 */
	@org.junit.Test
	public void testStartPlayer() throws SlickException {	
		assertTrue(testPlayer.isAlive());
		assertEquals(testPlayer.getHealth().getMaxHealth(), 100);
		assertEquals(testPlayer.getHealth().getCurrentHealth(), 100);
		testPlayer.getHealth().takeDmg(30);
		assertEquals(testPlayer.getHealth().getCurrentHealth(), 70);
		testPlayer.getHealth().heal(40);
		assertEquals(testPlayer.getHealth().getCurrentHealth(), 100); /**perchè maxHealth è 100 (non va fino a 110)*/
		testPlayer.upgradeMaxHealth(10);
		assertEquals(testPlayer.getHealth().getMaxHealth(), 110);
		testPlayer.getHealth().takeDmg(30);
		assertEquals(testPlayer.getHealth().getCurrentHealth(), 70);
		testPlayer.getHealth().heal(50);
		assertEquals(testPlayer.getHealth().getCurrentHealth(), 110); /** perchè maxHealth è 110 (non va fino a 120)*/
		assertEquals(testPlayer.getPosition(), new Pair<>(64,64));
		assertEquals(testPlayer.getDirection(), Direction.SOUTH);
		assertEquals(testPlayer.getDamage(), 10);
		testPlayer.upgradeDamage(20);
		assertEquals(testPlayer.getDamage(), 30);
		assertEquals(testPlayer.getLevel(), 0);		
		assertEquals(testPlayer.getInventory().getCoin(), 0);	
		assertEquals(testPlayer.getInventory().getKey(), 0);	
		testPlayer.getInventory().addCoin();
		testPlayer.getInventory().addKey();
		assertEquals(testPlayer.getInventory().getKey(), 1);	
		assertEquals(testPlayer.getInventory().getCoin(), 1);	
		assertEquals(testPlayer.getPlayerSpeed(), 1);
		testPlayer.upgradePlayerSpeed(10);
		assertEquals(testPlayer.getPlayerSpeed(), 11);
		assertEquals(testPlayer.getRateOfFire(), 1000);	
		testPlayer.upgradeRateOfFire(500);
		assertEquals(testPlayer.getRateOfFire(), 500);
		assertEquals(testPlayer.getRoom(), testRoom);
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
