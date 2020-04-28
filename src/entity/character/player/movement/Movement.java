package entity.character.player.movement;

import org.newdawn.slick.Input;

import design.utilities.Pair;
import entity.move.Direction;

/**
 * Interface that allows the player to move in the environment by pressing keyboard's keys
 */

public interface Movement {

	/** 
	 * According to the input received, this method will change player's coordinates and his direction.
	 * @param input, received from the keyboard
	 * @param pos, player's coordinates inside the room
	 * @param dir, player's direction inside the room
	 * @param speed, player's speed
	 * @return the new coordinates of the player
	 */
	public Pair<Integer, Integer> movePlayer (Input input, Pair<Integer, Integer> pos, Direction dir, int speed); 
	
	
	/**
	 * @return player's direction  
	 */	
	public Direction getDirection();
	
}
