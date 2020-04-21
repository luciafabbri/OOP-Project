package player.shoot;

import org.newdawn.slick.Input;

import bullet.Bullet;
import bullet.BulletPlayer;
import player.PlayerImpl;

public class BulletMovementImpl implements BulletMovement {
	
	private PlayerImpl player;
	
	public BulletMovementImpl(PlayerImpl player) {
		this.player = player;
	}
		
		@Override
		public void checkShooting(Input input) {
			
			if(input.isKeyDown(Input.KEY_SPACE)) {
				this.shoot();
			}
			
		}
		
		public void shoot(){
			Bullet bullet = new BulletPlayer(player.getPosition(), player.getDmg(), player.getBulletSpeed(),player.getDirection(), player.getRoom());  	
			if (bullet.isAlive()) {
				//aggiugerlo ad una lista di proiettili?? 
			}
			System.out.println("SPARATO!");
		}

}
