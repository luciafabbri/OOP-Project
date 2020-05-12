package dynamicBody.character.enemy.attack;

import dynamicBody.bullet.Bullet;
import dynamicBody.bullet.BulletMonsterImpl;
import dynamicBody.bullet.DistanceBull;
import dynamicBody.character.enemy.Enemy;
import dynamicBody.move.Direction;
import worldModel.RoomModel;
import worldModel.utilities.Pair;

/**
 * Class implements EnemyAttack use to create 1 bullet when enemy attack
 */
public class OneSideAtt implements EnemyAttack {

	private RoomModel currentRoom;
	private Enemy enemy;

	/**
	 * Default Constructor
	 * 
	 * @param room,  room where bullet spawn
	 * @param enemy, the Enemy that create this Bullet
	 */
	public OneSideAtt(RoomModel room, Enemy enemy) {
		currentRoom = room;
		this.enemy = enemy;
	}

	@Override
	public void createBullets(Pair<Integer, Integer> pos, Direction dir, int dmg) {

		Bullet bull = new BulletMonsterImpl(DistanceBull.calculateBullPos(dir, enemy), dmg, dir, currentRoom);

		enemy.addBullet(bull);

	}

}
