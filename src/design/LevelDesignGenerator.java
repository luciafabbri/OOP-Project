package design;

import java.io.IOException;

public interface LevelDesignGenerator {

	LevelDesign generateLevel(Integer levelNumber) throws IOException;
	
	RoomDesign generateRoom(Integer levelNumber, int roomID);
	
	utilities.BidirectionalGraph<RoomDesign> generateGraph();
}
