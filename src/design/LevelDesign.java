package design;

import utilities.BidirectionalGraph;

public interface LevelDesign {

	void addRoom(RoomDesign room);
	
	void addGraph(BidirectionalGraph<RoomDesign> roomsGraph);
}
