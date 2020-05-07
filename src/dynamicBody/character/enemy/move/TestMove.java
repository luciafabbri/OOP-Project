package dynamicBody.character.enemy.move;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

import design.RoomDesign;
import design.utilities.Pair;
import design.utilities.graphs.BidirectionalGraph;
import design.utilities.graphs.BreadthFirstSearch;
import design.utilities.graphs.Graph;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.character.enemy.creator.EnemyCreator;
import dynamicBody.character.enemy.creator.EnemyCreatorImpl;
import levels.Level;
import levels.LevelImpl;

/**
 * JUnit test for graph functionalities
 *
 */
public class TestMove {

	private static Enemy testMonster;

	private static EnemyCreator creator = new EnemyCreatorImpl();
	// private static Bullet testBullet;
	private static RoomDesign testRoom;

	@org.junit.Before
	public void initTest() throws IOException {
		try {
			// display.create is needed because default constructor of bulletPlayerImpl
			// contains an Image
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Level level = new LevelImpl(1);
		level.loadRooms();
		testRoom = level.getLevel().get(0).getRoom();

	}

	@org.junit.Test
	public void testStraightMove() {
		testMonster = creator.getMonsterA(new Pair<Integer, Integer>(128, 128), 10, 100, testRoom);

	}

	@org.junit.Test
	public void testRandomMove() {

	}

	@org.junit.Test
	public void testImmobilizedMove() {

	}

	@org.junit.Test
	public void testTeleportMove() {

	}

	@org.junit.Test
	public void testToPlayerMove() {

	}

}
