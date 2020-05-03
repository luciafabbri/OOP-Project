package coordination;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public interface Rendering {

	/**
	 * Method used to draw the wall in each room
	 */
	void drawWalls();
	
	/**
	 * Method used to draw the floor in each room
	 */
	void drawFloor();

	/**
	 * Method used to draw the items placed in each room
	 */
	void drawItems();
	
	/**
	 * Method used to draw the doors (if they're present) in each room
	 */
	void drawDoors();
	
	/**
	 * Method used to draw the enemies in each room
	 */
	void drawEnemies();

	/**
	 * Method used to draw the obstacles place in each room
	 */
	void drawObstacles();

	/**
	 * Method used to draw the right animation of the Player, based on if he's moving or not
	 * @param input, used to see if the Player is moved or not
	 */
	void drawMain(Input input);
	
	/**
	 * Method used to draw the modifiers placed in each room
	 */
	void drawMod();
	
	/**
	 * Method used to draw the top of the doors in each room, so that the it gives the Player the illusion of traversing room
	 * @throws SlickException
	 * @see SlickException
	 */
	void drawDoorTop() throws SlickException;
}
