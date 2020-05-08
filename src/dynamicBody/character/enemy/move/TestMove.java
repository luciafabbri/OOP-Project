package dynamicBody.character.enemy.move;

import static org.junit.Assert.*;

import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.SlickException;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.character.enemy.EnemyImpl;
import dynamicBody.character.enemy.attack.TypeAttack;
import dynamicBody.character.enemy.creator.TypeEnemy;
import dynamicBody.move.Direction;
import gameEntities.Obstacle;
import levels.Level;
import levels.LevelImpl;

/**
 * JUnit test for Enemy move functionalities
 *
 */
public class TestMove {

	// private static Bullet testBullet;
	private static RoomDesign testRoom;

	@org.junit.BeforeClass
	public static void initTest() throws IOException {
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
		// RIMUOVO TUTTI GLI OSCACOLI PER IL TEST
		//testRoom.getObstacleSet().removeAll(testRoom.getObstacleSet());

	}

	@org.junit.Test
	public void testStraightMove() {
		/*
		 * CONTROLLO CHE PER OGNI DIREZIONE IL NEMICO SI MUOVA DALLA PARTE GIUSTA
		 */

		Direction.getDirectionList(true).forEach(d -> {

			Enemy testStraight = new EnemyImpl(new Pair<Integer, Integer>(128, 128), 10, 1, 100, TypeMove.STRAIGHT, d,
					TypeAttack.ONE_SIDE, testRoom, TypeEnemy.MONSTER1);
			testStraight.updatePos();
			assertEquals(new Pair<Integer, Integer>(128 + d.getAbscissa(), 128 + d.getOrdinate()),
					testStraight.getPosition());
			testStraight.updatePos();
			testStraight.updatePos();
			testStraight.updatePos();
			assertEquals(new Pair<Integer, Integer>(128 + d.getAbscissa() * 4, 128 + d.getOrdinate() * 4),
					testStraight.getPosition());
		});

		/*
		 * CONTROLLO CHE IL NEMICO UNA VOLTA SBATTUTO NEL LIMITI CAMBI DIREZIONI
		 */
		Enemy testStraight;
		testStraight = new EnemyImpl(new Pair<Integer, Integer>(64, GameSettings.LIMITDOWN - 65), 10, 1, 100,
				TypeMove.STRAIGHT, Direction.SOUTH, TypeAttack.ONE_SIDE, testRoom, TypeEnemy.MONSTER1);

		// IL NEMICO SI MUOVE CORRETTAMENTE VERSO IL BASSO ED ORA SI TROVA ATTACCATO AL
		// MURO
		testStraight.updatePos();
		assertEquals(new Pair<Integer, Integer>(64, GameSettings.LIMITDOWN - 64), testStraight.getPosition());
		assertEquals(Direction.SOUTH, testStraight.getDirection());

		// IL NEMICO CERCA DI MUOVERSI VERSO IL BASSO MA ESSENDO ATTACCATO AL MURO
		// SBATTE E CAMBIA DIREZIONE
		testStraight.updatePos();
		assertEquals(new Pair<Integer, Integer>(64, GameSettings.LIMITDOWN - 64), testStraight.getPosition());
		assertEquals(Direction.NORTH, testStraight.getDirection());

		// IL NEMICO HA CAMBIATO DIREZIONE E SI MUOVE DALLA PARTE OPPOSTA
		testStraight.updatePos();
		assertEquals(new Pair<Integer, Integer>(64, GameSettings.LIMITDOWN - 65), testStraight.getPosition());
		assertEquals(Direction.NORTH, testStraight.getDirection());

		/*
		 * CONTROLLO CHE IL NEMICO SBATTA CONTRO GLI OSTACOLI
		 */
		testStraight = new EnemyImpl(new Pair<Integer, Integer>(64, 128), 10, 1, 100, TypeMove.STRAIGHT,
				Direction.SOUTH, TypeAttack.ONE_SIDE, testRoom, TypeEnemy.MONSTER1);
		try {
			testRoom.addObstacle(new Obstacle(new Pair<Integer, Integer>(64, 128 + 65)));
		} catch (SlickException e) {
			e.printStackTrace();
		}
		// IL NEMICO SI MUOVE CORRETTAMENTE VERSO IL BASSO ED ORA SI TROVA ATTACCATO
		// ALL'OSTACOLO
		testStraight.updatePos();
		assertEquals(new Pair<Integer, Integer>(64, 128 + 1), testStraight.getPosition());
		assertEquals(Direction.SOUTH, testStraight.getDirection());

		// IL NEMICO CERCA DI MUOVERSI VERSO IL BASSO MA ESSENDO ATTACCATO ALL'OSTACOLO
		// SBATTE E CAMBIA DIREZIONE
		testStraight.updatePos();
		assertEquals(new Pair<Integer, Integer>(64, 128 + 1), testStraight.getPosition());
		assertEquals(Direction.NORTH, testStraight.getDirection());

		// IL NEMICO HA CAMBIATO DIREZIONE E SI MUOVE DALLA PARTE OPPOSTA
		testStraight.updatePos();
		assertEquals(new Pair<Integer, Integer>(64, 128), testStraight.getPosition());
		assertEquals(Direction.NORTH, testStraight.getDirection());
	}

	@org.junit.Test
	public void testRandomMove() {
		Enemy testRandom;
		testRandom = new EnemyImpl(new Pair<Integer, Integer>(250, 250), 10, 1, 100, TypeMove.RANDOM, Direction.SOUTH,
				TypeAttack.ONE_SIDE, testRoom, TypeEnemy.MONSTER1);
		// IL MOVIMENTO RANDOM UNA VOLTA INIZIALIZZATO CAMBIA LA DIREZIONE OGNI TOT PASSI
		testRandom.updatePos();
		testRandom.updatePos();
		assertNotEquals(new Pair<Integer, Integer>(250, 250), testRandom.getPosition());
		assertNotEquals(Direction.SOUTH, testRandom.getDirection());

	}

	@org.junit.Test
	public void testImmobilizedMove() {
		Enemy testImmobilized;
		testImmobilized = new EnemyImpl(new Pair<Integer, Integer>(64, 64), 10, 1, 100, TypeMove.IMMOBILIZED, Direction.SOUTH,
				TypeAttack.ONE_SIDE, testRoom, TypeEnemy.MONSTER1);
		//AGGIORNARE LA POSIZIONE RITORNERA SEMPRE QUELLA PRECEDENTE		
		testImmobilized.updatePos();
		testImmobilized.updatePos();
		testImmobilized.updatePos();
		assertEquals(new Pair<Integer, Integer>(64, 64), testImmobilized.getPosition());
		assertEquals(Direction.SOUTH, testImmobilized.getDirection());

	}

	@org.junit.Test
	public void testTeleportMove() {
		Enemy testTeleport;
		testTeleport = new EnemyImpl(new Pair<Integer, Integer>(250, 250), 10, 1, 100, TypeMove.TELEPORT, Direction.SOUTH,
				TypeAttack.ONE_SIDE, testRoom, TypeEnemy.MONSTER1);
		// IL MOVIMENTO TELEPORT SI TELETRASPORTA IN UNA POSIZIONE E RIMANI LI PER UN PAIO DI SECONDI
		testTeleport.updatePos();
		assertNotEquals(new Pair<Integer, Integer>(250, 250), testTeleport.getPosition());
		Pair<Integer, Integer> newPos = testTeleport.getPosition();
		Direction newDirection = testTeleport.getDirection();
		testTeleport.updatePos();
		assertEquals(newPos, testTeleport.getPosition());
		assertEquals(newDirection, testTeleport.getDirection());
		
	}

}
