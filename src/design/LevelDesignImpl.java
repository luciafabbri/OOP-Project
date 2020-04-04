package design;

import java.util.LinkedList;

import utilities.BidirectionalGraph;

public class LevelDesignImpl implements LevelDesign {

	private boolean isGraphSet = false;
	LinkedList<RoomDesign> rooms = new LinkedList<>();
	BidirectionalGraph<RoomDesign> roomsGraph;

	public LinkedList<RoomDesign> getRooms() {
		return rooms;
	}
	
	public BidirectionalGraph<RoomDesign> getRoomsGraph() {
		return roomsGraph;
	}

	public void addRoom(RoomDesign room) {
		if(isGraphSet) {	//rooms may be added so long as the graph is not set yet
			throw new IllegalStateException();
		}
		rooms.add(room);
	}
	
	public void addGraph(BidirectionalGraph<RoomDesign> roomsGraph) {
		if(isGraphSet) { // the graph for a given room may only be set once
			throw new IllegalStateException();
		}
		this.roomsGraph = roomsGraph;
		isGraphSet = true;
	}
	
}
