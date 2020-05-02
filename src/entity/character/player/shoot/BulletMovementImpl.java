package entity.character.player.shoot;

import org.newdawn.slick.Input;
import entity.bullet.Bullet;
import entity.bullet.BulletPlayerImpl;
import entity.character.player.PlayerImpl;

/**
 * Class that implements interface BulletMovement used to check if the user is pressing the space bar 
 * in order to make the player start shooting, by creating a new bullet of type player 
 */

public class BulletMovementImpl implements BulletMovement {
	
	private PlayerImpl player;
	private long startMillis = 0; 
	private long stopMillis;
	
	/**
	 * Default constructor
	 * @param player, player that will start shooting
	 */
	public BulletMovementImpl(PlayerImpl player) {
		this.player = player;
	}
		
	@Override
	public void checkShooting(Input input) {
		stopMillis = System.currentTimeMillis();
		if(input.isKeyDown(Input.KEY_SPACE) && (stopMillis - startMillis > player.getRof())) {
			this.shoot();
			startMillis = System.currentTimeMillis();
		}	
	}
	
	/**
	 * Method used to make the player start shooting in the direction that he's going
	 * A new BulletPlayerImpl() object is created
	 */	
	private void shoot(){
		Bullet bullet = new BulletPlayerImpl(player.getPosition(), player.getDamage(),player.getDirection(), player.getRoom());  	
		if (bullet.isAlive()) {
			player.getRoomBullets().add(bullet);
			player.getBowShoot().play(1.0f, 0.05f);
		}
	}

}
