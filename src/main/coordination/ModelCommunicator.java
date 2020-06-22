package main.coordination;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public interface ModelCommunicator {

//	/**
//	 * Method used to check if the Player has used one of the doors to, and then changes the room to the appropriate one
//	 * @param input //TODO DELETE THE PARAM CAUSE ITS JUST FOR TESTING
//	 */
//	void switchRooms(Input input);
//
//	/**
//	 * Method that sets a variable inside Player to check if the room is clear of enemies
//	 */
//	void setRoomCleared();
//
//	/**
//	 * Method that calls the movement method insde Player to move him, changing his coordinates
//	 * @param input, so that the Player can see in which direction to move
//	 * @throws SlickException
//	 * @see SlickException
//	 */
//	void moveMain(Input input) throws SlickException;
//
//	/**
//	 * Method that calls the shoot method inside Player
//	 * @param input, so that the Player can check if the right button for shooting has been pressed
//	 */
//	void shootMain(Input input);
//
//	/**
//	 * Method calls the movement method for every enemy placed inside each room
//	 */
//	void moveEnemies();
//
//	/**
//	 * Method that calls the shoot method for every enemy placed inside each room
//	 */
//	void shootEnemies();
//	
//	void pauseMenu(Input input);

	void update() throws SlickException;

}