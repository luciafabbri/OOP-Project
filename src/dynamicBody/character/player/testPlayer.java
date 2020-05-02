package dynamicBody.character.player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import design.RoomDesignImpl;
import design.utilities.GameSettings;
import design.utilities.Pair;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.character.enemy.EnemyCreatorImpl;
import dynamicBody.character.enemy.EnemyImpl;
import dynamicBody.move.Direction;

class testPlayer {

	@Test
	void testPlayer() {
		Player player = new PlayerImpl(new Pair<Integer,Integer>(GameSettings.TILESIZE, GameSettings.TILESIZE), Direction.SOUTH, 0);
		assertEquals(player.getHealth().getCurrentHealth(),100);
		assertEquals(player.getPosition(), new Pair<>(64,64));
		assertEquals(player.getDirection(), Direction.SOUTH);
		assertEquals(player.getDamage(), 10);
		assertEquals(player.getLevel(), 0);
	//	assertEquals (this.player.getMove().movePlayer(KEY_A, player.getPosition(), player.getDirection(), player.getPlayerSpeed()), player.setPosition(new Pair<>(GameSettings.TILESIZE,GameSettings.TILESIZE)));
	//	this.player.getMove().movePlayer( input.isKeyDown(Input.KEY_W), player.getPosition(), player.getDirection(), player.getPlayerSpeed());
	//	this.player.getMove().movePlayer( input.isKeyDown(Input.KEY_D), player.getPosition(), player.getDirection(), player.getPlayerSpeed());
	//	this.player.getMove().movePlayer( input.isKeyDown(Input.KEY_S), player.getPosition(), player.getDirection(), player.getPlayerSpeed());
	//	this.player.getBullet().checkShooting(input.isKeyDown(Input.KEY_SPACE) );
		
	}

}
