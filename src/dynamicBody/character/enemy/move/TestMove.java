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
 * JUnit test for graph functionalities
 *
 */
public class TestMove {

	private static Enemy testMonster;

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
		// RIMUOVO TUTTI GLI OSCACOLI PER IL TEST
		testRoom.getObstacleSet().removeAll(testRoom.getObstacleSet());

	}

	@org.junit.Test
	public void testStraightMove() {
		/* 
		 * CONTROLLO CHE PER OGNI DIREZIONE IL NEMICO SI MUOVA DALLA PARTE GIUSTA
		 */
		Direction.getDirectionList(true).forEach(d -> {
			testMonster = new EnemyImpl(new Pair<Integer, Integer>(128, 128), 10, 1, 100, TypeMove.STRAIGHT, d,
					TypeAttack.ONE_SIDE, testRoom, TypeEnemy.MONSTER1);
			testMonster.updatePos();
			assertEquals(new Pair<Integer, Integer>(128 + d.getAbscissa(), 128 + d.getOrdinate()),
					testMonster.getPosition());
			testMonster.updatePos();
			testMonster.updatePos();
			testMonster.updatePos();
			assertEquals(new Pair<Integer, Integer>(128 + d.getAbscissa() * 4, 128 + d.getOrdinate() * 4),
					testMonster.getPosition());
		});

		/*
		 *  CONTROLLO CHE IL NEMICO UNA VOLTA SBATTUTO NEL LIMITI CAMBI DIREZIONI
		 */
		
		testMonster = new EnemyImpl(new Pair<Integer, Integer>(64, GameSettings.LIMITDOWN - 65), 10, 1, 100,
				TypeMove.STRAIGHT, Direction.SOUTH, TypeAttack.ONE_SIDE, testRoom, TypeEnemy.MONSTER1);
		
		// IL NEMICO SI MUOVE CORRETTAMENTE VERSO IL BASSO ED ORA SI TROVA ATTACCATO AL MURO
		testMonster.updatePos();
		assertEquals(new Pair<Integer, Integer>(64, GameSettings.LIMITDOWN - 64), testMonster.getPosition());
		assertEquals(Direction.SOUTH, testMonster.getDirection());
		
		// IL NEMICO CERCA DI MUOVERSI VERSO IL BASSO MA ESSENDO ATTACCATO AL MURO SBATTE E CAMBIA DIREZIONE
		testMonster.updatePos();
		assertEquals(new Pair<Integer, Integer>(64, GameSettings.LIMITDOWN - 64), testMonster.getPosition());
		assertEquals(Direction.NORTH, testMonster.getDirection());
		
		//IL NEMICO HA CAMBIATO DIREZIONE E SI MUOVE DALLA PARTE OPPOSTA
		testMonster.updatePos();
		assertEquals(new Pair<Integer, Integer>(64, GameSettings.LIMITDOWN - 65), testMonster.getPosition());
		assertEquals(Direction.NORTH, testMonster.getDirection());
		
		/*
		 * CONTROLLO CHE IL NEMICO SBATTA CONTRO GLI OSTACOLI
		 */
		testMonster = new EnemyImpl(new Pair<Integer, Integer>(64, 128), 10, 1, 100,
				TypeMove.STRAIGHT, Direction.SOUTH, TypeAttack.ONE_SIDE, testRoom, TypeEnemy.MONSTER1);
		try {
			testRoom.addObstacle(new Obstacle(new Pair<Integer, Integer>(64, 128 + 65)));
		} catch (SlickException e) {
			e.printStackTrace();
		}
		// IL NEMICO SI MUOVE CORRETTAMENTE VERSO IL BASSO ED ORA SI TROVA ATTACCATO ALL'OSTACOLO
		testMonster.updatePos();
		assertEquals(new Pair<Integer, Integer>(64, 128 + 1), testMonster.getPosition());
		assertEquals(Direction.SOUTH, testMonster.getDirection());
		
		// IL NEMICO CERCA DI MUOVERSI VERSO IL BASSO MA ESSENDO ATTACCATO ALL'OSTACOLO SBATTE E CAMBIA DIREZIONE
		testMonster.updatePos();
		assertEquals(new Pair<Integer, Integer>(64, 128 + 1), testMonster.getPosition());
		assertEquals(Direction.NORTH, testMonster.getDirection());
		
		//IL NEMICO HA CAMBIATO DIREZIONE E SI MUOVE DALLA PARTE OPPOSTA
		testMonster.updatePos();
		assertEquals(new Pair<Integer, Integer>(64, 128), testMonster.getPosition());
		assertEquals(Direction.NORTH, testMonster.getDirection());
	}

//	@org.junit.Test
//	public void testRandomMove() {
//
//	}
//
//	@org.junit.Test
//	public void testImmobilizedMove() {
//
//	}
//
//	@org.junit.Test
//	public void testTeleportMove() {
//
//	}
//
//	@org.junit.Test
//	public void testToPlayerMove() {
//
//	}

}
