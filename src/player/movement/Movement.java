package player.movement;

import org.newdawn.slick.Input;
import design.utilities.Pair;
import utility.Direction;

/**
 * Interface that allows the player to move in the environment by pressing keyboard's keys
 */

public interface Movement {

	/** 
	 * According to the input received, this method will change player's coordinates and his direction.
	 * @param the input from the keyboard, the coordinates of the player and his direction
	 * @return the new coordinates of the player
	 */
	public Pair<Integer, Integer> movePlayer (Input input, Pair<Integer, Integer> pos, Direction dir, int speed); 
	
	
	/**
	 * @return Player's direction  
	 */	
	public Direction getDirection();
	
}
