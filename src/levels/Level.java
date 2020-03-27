package levels;

import java.util.List;

public interface Level {
	
	final static int WIDTH = 1296;
	final static int HEIGHT = 720;
	final static int TILESIZE = 48;
	
	void loadScreenTest();
	
	List<Room1> getLevel();

}