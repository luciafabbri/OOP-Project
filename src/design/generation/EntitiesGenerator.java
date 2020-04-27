package design.generation;

import org.newdawn.slick.SlickException;

import design.RoomDesignImpl;

/**
 * An interface that models the entity generator for rooms. A generation method
 * is present for each entity that may be present inside levels.
 *
 */
public interface EntitiesGenerator {

	/**
	 * @param numOfPickupables, number of pickupable entities to be randomly
	 *                          generated in the room
	 * @throws SlickException
	 */
	void generatePickupables(int numOfPickupables) throws SlickException;

	/**
	 * Stairs generator. Each room is required to have either a Stairs object OR a
	 * Boss object.
	 * 
	 * @throws SlickException
	 */
	void generateStairs() throws SlickException;

	/**
	 * Boss generator. Each room is required to have either a Stairs object OR a
	 * Boss object.
	 * 
	 * @throws SlickException
	 */
	void generateBoss() throws SlickException;

	/**
	 * @param numOfEnemies, number of enemy entities to be randomly generated in the
	 *                      room
	 * @throws SlickException
	 */
	void generateEnemies(int numOfEnemies) throws SlickException;

	/**
	 * @param numOfObstacles, number of obstacle entities to be randomly generated
	 *                        in the room
	 * @throws SlickException
	 */
	void generateObstacles(int numOfObstacles) throws SlickException;

}
