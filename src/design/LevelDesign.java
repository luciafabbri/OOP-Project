package design;

import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

import design.utilities.BidirectionalGraph;
import design.utilities.Door;

public interface LevelDesign {
	
	 LinkedList<RoomDesign> getRooms();
	
	BidirectionalGraph<RoomDesign> getRoomsGraph();

	Map<RoomDesign, Map<Door, Optional<RoomDesign>>> getDoorsLayout();

	void addRoom(RoomDesign room);
	
	void addGraph(BidirectionalGraph<RoomDesign> roomsGraph);
	
	void addDoorsLayout(Map<RoomDesign, Map<Door, Optional<RoomDesign>>> doorsLayout);
}
