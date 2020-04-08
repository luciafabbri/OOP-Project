package bullet.player;

import org.newdawn.slick.Input;
import bullet.Bullet;
import bullet.BulletImpl;
import bullet.BulletPlayer;

public class BulletMovementImpl implements BulletMovement {

	private boolean spacePressed = false;
	
	public BulletMovementImpl() {
	}
		
		@Override
		public void checkShooting(Input input) {
			
			if(input.isKeyDown(Input.KEY_SPACE)) {
				spacePressed = true;
			}
			
		}
		
		public void shoot(){
			if(spacePressed == true) {
//			Bullet playerBullet = new BulletPlayer();  
			}
			spacePressed = false;
		}
	
}
