package design;

import java.util.LinkedList;

import designUtilities.BidirectionalGraph;

public interface LevelDesign {
	
	 LinkedList<RoomDesign> getRooms();
	
	BidirectionalGraph<RoomDesign> getRoomsGraph();

	void addRoom(RoomDesign room);
	
	void addGraph(BidirectionalGraph<RoomDesign> roomsGraph);
}
