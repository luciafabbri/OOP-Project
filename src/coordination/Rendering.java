package coordination;

import org.newdawn.slick.SlickException;

public interface Rendering {

	void drawWalls();
	
	void drawFloor();

	void drawItems();
	
	void drawDoors();

	void drawObstacles();

	void drawMain();
	
	void drawDoorTop() throws SlickException;
}
