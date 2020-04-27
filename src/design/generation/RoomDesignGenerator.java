package design.generation;

import org.newdawn.slick.SlickException;
import design.RoomDesign;

/**
 * An interface that models the rooms generators, the entities that
 * pseudo-randomly generate game rooms.
 *
 */
public interface RoomDesignGenerator {

	/**
	 * @param index, integer used to identify the room inside a level
	 * @return a design.RoomDesign object, also known as the model of a room
	 * @throws SlickException
	 */
	RoomDesign generateRoom(int index) throws SlickException;

}
