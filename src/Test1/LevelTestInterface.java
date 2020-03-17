package Test1;

import java.util.List;
import java.util.Map;

public interface LevelTestInterface {
	
	final static int WIDTH = 1296;
	final static int HEIGHT = 720;
	final static int TILESIZE = 48;
	
	void loadScreenTest();

	Map<TileTestImpl, List<Pair<Integer, Integer>>> getRoom();

}