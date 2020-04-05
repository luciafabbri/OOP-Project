package bullet.player;

import org.newdawn.slick.Input;
import org.newdawn.slick.state.*;

import bullet.Bullet;
import bullet.BulletImpl;
import utility.Pair;

import java.util.List;

import org.newdawn.slick.*;

public class BulletMovementImpl implements BulletMovement {

	private boolean spacePressed = false;
	
	/* devo solo fare che quando uno preme la barra spaziatrice un oggetto proiettile parte 
	 * nella direzione che sta guardando il personaggio 
	 */
	
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
//				Bullet playerBullet = new BulletImpl(null, 0, null, null, null);   costruisco un bullet in ogni modo
			}
			spacePressed = false;
		}

		

	
	
}
