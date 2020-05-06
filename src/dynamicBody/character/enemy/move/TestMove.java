package dynamicBody.character.enemy.move;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import design.RoomDesign;
import design.utilities.Pair;
import design.utilities.graphs.BidirectionalGraph;
import design.utilities.graphs.BreadthFirstSearch;
import design.utilities.graphs.Graph;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.character.enemy.creator.EnemyCreator;
import dynamicBody.character.enemy.creator.EnemyCreatorImpl;

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
	public void initTest() {

	}

	@org.junit.Test
	public void testStraightMove() {

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
