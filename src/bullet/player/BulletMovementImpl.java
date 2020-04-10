package bullet.player;

import org.newdawn.slick.Input;
import bullet.Bullet;
import bullet.BulletImpl;
import bullet.BulletPlayer;

public class BulletMovementImpl implements BulletMovement {
	
	public BulletMovementImpl() {
	}
		
		@Override
		public void checkShooting(Input input) {
			
			if(input.isKeyDown(Input.KEY_SPACE)) {
				this.shoot();
			}
			
		}
		
		public void shoot(){
				System.out.println("PREMUTO!");
//			Bullet playerBullet = new BulletPlayer();  	
		}
}
