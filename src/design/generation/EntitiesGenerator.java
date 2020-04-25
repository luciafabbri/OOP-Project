package design.generation;

import org.newdawn.slick.SlickException;

import design.RoomDesignImpl;

public interface EntitiesGenerator {

	void generatePickupables(int numOfPickupables) throws SlickException;
	
	void generateStairs() throws SlickException;
	
	void generateBoss() throws SlickException;
	
	void generateEnemies(int numOfEnemies) throws SlickException;
	
	void generateObstacles(int numOfObstacles) throws SlickException;
	
}
