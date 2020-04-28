package entity.character.player.shoot;

import org.newdawn.slick.Input;

import design.utilities.Pair;
import entity.bullet.BulletImpl;
import entity.move.Direction;

/**
 * An interface used to create player's bullets 
 */

public interface BulletMovement {

	/** 
	 * Method used to check if the space bare is pressed, which means that the player would start shooting
	 * @param input, received from the keyboard 
	 */
	public void checkShooting(Input input);
		
	/**
	 * Method used to make the player start shooting in the direction that he's going
	 * A new BulletPlayerImpl() object is created
	 */
	public void shoot();	
	
}
