package bullet.player;

import org.newdawn.slick.Input;
import utility.Pair;

public interface BulletMovement {

	/** 
	 * 
	 * controllo se sta sparando, default è true
	 *  
	 */
	public void checkShooting(Input input);
		
	/**
	 * 
	 * se il check è positivo, creo una List<Pair<>> che sono i proiettili e 
	 * partono dalla direzione in cui è girato il personaggio
	 * 
	 */
	public void shoot();
	
	
	
	
}
