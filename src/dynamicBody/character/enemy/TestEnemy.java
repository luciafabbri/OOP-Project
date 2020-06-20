package dynamicBody.character.enemy;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.SlickException;

import dynamicBody.character.enemy.attack.TypeAttack;
import dynamicBody.character.enemy.creator.TypeEnemy;
import dynamicBody.character.enemy.move.TypeMove;
import dynamicBody.move.Direction;
import levels.LevelComp;
import levels.LevelCompImpl;
import worldModel.RoomModel;
import worldModel.utilities.Pair;

/**
 * JUnit test for player's and bullet's initial functionalities
 */

public class TestEnemy {

	private static RoomModel testRoom;
	
	@org.junit.BeforeClass
	public static void initTest() throws IOException {
		try {
			// display.create is needed because default constructor of bulletPlayerImpl
			// contains an Image
			Display.create();
		} catch (LWJGLException e) {
			Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, e);
		}
		LevelComp level = new LevelCompImpl(1);
		level.loadRooms();
		testRoom = level.getLevel().get(0).getRoom();
		// RIMUOVO TUTTI GLI OSCACOLI PER IL TEST
		testRoom.getObstacleSet().removeAll(testRoom.getObstacleSet());

	}

	/**
	 * To check initial enemy's conditions  
	 * @throws SlickException 
	 */
	@org.junit.Test
	public void testStartPlayer() throws SlickException {
		Enemy testEnemy = new EnemyImpl(new Pair<Integer, Integer>(128, 128), 10, 1, 100,
				TypeMove.STRAIGHT, Direction.SOUTH, TypeAttack.ONE_SIDE, testRoom, TypeEnemy.BOWMAN);
		assertTrue(testEnemy.isAlive());
		testEnemy.takeDamage(30);
		assertTrue(testEnemy.isAlive());
		assertEquals(new Pair<>(128,128), testEnemy.getPosition());
		assertEquals(Direction.SOUTH, testEnemy.getDirection());
		assertEquals(TypeEnemy.BOWMAN, testEnemy.getTypeEnemy());
		testEnemy.takeDamage(70);
		assertFalse(testEnemy.isAlive());
	}
	

}
