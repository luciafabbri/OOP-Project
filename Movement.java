package player.movement;

import org.newdawn.slick.Input;

import player.movement.Direction;
import utility.Pair;

/**
 * 
 * Interface that allows the player to move in the environment
 * 
 */

public interface Movement {

	/** 
	 * 
	 * this method needs the input from the container and the coordinates of the player 
	 * It returns the new coordinates of the player 
	 * 
	 */
	public Pair<Integer, Integer> movePlayer (Input input, Pair<Integer, Integer> pos, Direction dir); 
	
	public Direction getDirection();
	
}
