package player.movement;

import org.newdawn.slick.Input;
import utility.Pair;
import utility.Direction;

/**
 * 
 * Interface that allows the player to move in the environment
 * 
 */

public interface Movement {

	/** 
	 * 
	 * This method needs the input from the container, the coordinates of the player and his direction.
	 * According to the input received, it will change his coordinates and his direction.
	 * It returns the new coordinates of the player.
	 * 
	 */
	public Pair<Integer, Integer> movePlayer (Input input, Pair<Integer, Integer> pos, Direction dir); 
	
	
	/**
	 * 
	 * Methods used to get Player's direction
	 *  
	 */	
	public Direction getDirection();
	
}
