package coordination;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public interface Rendering {

	void drawWalls();
	
	void drawFloor();

	void drawItems();
	
	void drawDoors();
	
	void drawEnemies();

	void drawObstacles();

	void drawMain(Input input);
	
	void drawMod();
	
	void drawDoorTop() throws SlickException;
	
	void drawMainProj();
}
