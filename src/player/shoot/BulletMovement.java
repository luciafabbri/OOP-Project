package player.shoot;

import org.newdawn.slick.Input;

import design.utilities.Pair;
import utility.Direction;

public interface BulletMovement {

	/** 
	 * 
	 * Method used to check if the space bare is pressed, which means that the player would start shooting.
	 * Set true value in a variable if that happens.
	 *  
	 */
	public void checkShooting(Input input);
		
	/**
	 * 
	 * Method used to make the player start shooting in the direction that he's going.
	 * Create a new Bullet() object.
	 * 
	 */
	public void shoot(Pair<Integer,Integer> pos, int dmg, Direction dir);
	
	
	
	
}
