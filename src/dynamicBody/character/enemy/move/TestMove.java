package dynamicBody.character.enemy.move;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.SlickException;

import design.RoomDesign;
import design.RoomDesignImpl;
import design.generation.RoomDesignGenerator;
import design.generation.RoomDesignGeneratorImpl;
import design.utilities.Pair;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.character.enemy.EnemyImpl;
import dynamicBody.character.enemy.attack.TypeAttack;
import dynamicBody.character.enemy.creator.EnemyCreator;
import dynamicBody.character.enemy.creator.EnemyCreatorImpl;
import dynamicBody.character.enemy.creator.TypeEnemy;
import dynamicBody.move.Direction;

class TestMove {

	private static Enemy testMonster;
	private static EnemyCreator creator = new EnemyCreatorImpl();
	// private static Bullet testBullet;
	private static RoomDesign testRoom;

	private static List<Direction> normalDir = Direction.getDirectionList(true);

	@org.junit.BeforeClass
	public static void initTest() {
		try {
			// display.create is needed because default constructor of bulletPlayerImpl
			// contains an Image
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// testBullet = new BulletPlayerImpl(testPlayer.getPosition(),
		// testPlayer.getDamage(), testPlayer.getDirection(), testRoom);
		testMonster = creator.getMonsterA(new Pair<>(128, 128), 10, 100, testRoom);
	}

	@Test
	void testStraight() {
		System.out.println(testMonster.isAlive());
//		normalDir.forEach(d -> {
//			testMonster = new EnemyImpl(new Pair<Integer, Integer>(128, 128), 10, 1, 100, TypeMove.STRAIGHT, d,
//					TypeAttack.ONE_SIDE, testRoom, TypeEnemy.MONSTER1);
//			testMonster.updatePos();
//			testMonster.updatePos();
//			Pair<Integer, Integer> checkPos = new Pair<>(128 + (d.getAbscissa() * 2), 128 + (d.getOrdinate() * 2));
//			assertEquals(testMonster.getPosition(), checkPos);
//		});

	}

	@Test
	void testTeleport() {

		/*
		 * Enemy mon = new monster("Mon", new Pair<Integer,Integer>(100, 100), "ciao",
		 * 1, 1, TypeMove.TELEPORT, Direction.getRandomDir()); int x = 0;
		 * 
		 * while(x<25) { x++; mon.updatePos(); System.out.println(mon.getName() + " -> "
		 * + mon.getPos());
		 * 
		 * }
		 */

	}

	@Test
	void testRandom() {
		/*
		 * Enemy mon = new Monster("Mon", new Pair<Integer,Integer>(100, 615), "ciao",
		 * 1, 1, TypeMove.RANDOM, Direction.SOUTH); int x = 0;
		 * 
		 * while(x<35) { x++; mon.updatePos();- System.out.println(mon.getName() +
		 * " -> " + mon.getPos()); System.out.println(mon.getDirection());
		 * 
		 * }
		 */
	}

	@Test
	void testImmobilized() {/*
							 * Enemy mon = new Monster("Mon", new Pair<Integer,Integer>(100, 100), "ciao",
							 * 1, 1, TypeMove.IMMOBILIZED, Direction.SOUTH); mon.updatePos();
							 * System.out.println(mon.getDirection());
							 */
	}

}
