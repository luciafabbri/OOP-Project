package entity.character.player.shoot;

import org.newdawn.slick.Input;

import bullet.Bullet;
import bullet.BulletPlayer;
import bullet.BulletPlayerImpl;
import entity.character.player.PlayerImpl;

public class BulletMovementImpl implements BulletMovement {
	
	private PlayerImpl player;
	private long startMillis = 0; 
	private long stopMillis;
	
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
		
		public void shoot(){
			BulletPlayer bullet = new BulletPlayerImpl(player.getPosition(), player.getDmg(), player.getBulletSpeed(),player.getDirection(), player.getRoom());  	
			if (bullet.isAlive()) {
				player.getRoomBullets().add(bullet);
				player.getBowShoot().play(1.0f, 0.05f);
			}
		}

}
