package player.shoot;

import org.newdawn.slick.Input;

import bullet.Bullet;
import bullet.BulletPlayer;
import bullet.BulletPlayerImpl;
import player.PlayerImpl;

public class BulletMovementImpl implements BulletMovement {
	
	private PlayerImpl player;
	
	public BulletMovementImpl(PlayerImpl player) {
		this.player = player;
	}
		
		@Override
		public void checkShooting(Input input) {
			
			if(input.isKeyPressed(Input.KEY_SPACE)) {
				this.shoot();
			}
			
		}
		
		public void shoot(){
			BulletPlayer bullet = new BulletPlayerImpl(player.getPosition(), player.getDmg(), player.getBulletSpeed(),player.getDirection(), player.getRoom());  	
			if (bullet.isAlive()) {
				player.getRoomBullets().add(bullet); 
			}
		}

}
