package design;

import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

import design.utilities.enums.Door;
import design.utilities.graphs.BidirectionalGraph;

/**
 * Implementation of LevelDesign interface
 *
 */
public class LevelDesignImpl implements LevelDesign {

	private boolean isGraphSet = false;
	LinkedList<RoomDesign> rooms = new LinkedList<>();
	BidirectionalGraph<RoomDesign> roomsGraph;
	Map<RoomDesign, Map<Door, Optional<RoomDesign>>> doorsLayoutMap;

	@Override
	public LinkedList<RoomDesign> getRooms() {
		return rooms;
	}

	@Override
	public BidirectionalGraph<RoomDesign> getRoomsGraph() {
		return roomsGraph;
	}

	@Override
	public void addRoom(RoomDesign room) {
		if (isGraphSet) { // rooms may be added so long as the graph is not set yet
			throw new IllegalStateException();
		}
		rooms.add(room);
	}

	@Override
	public void addGraph(BidirectionalGraph<RoomDesign> roomsGraph) {
		if (isGraphSet) { // the graph for a given room may only be set once
			throw new IllegalStateException();
		}
		this.roomsGraph = roomsGraph;
		isGraphSet = true;
	}

	@Override
	public void addDoorsLayout(Map<RoomDesign, Map<Door, Optional<RoomDesign>>> doorsLayout) {
		if (!isGraphSet) { // door layout may be established only after graph generation
			throw new IllegalStateException();
		}
		this.doorsLayoutMap = doorsLayout;

	}

	@Override
	public Map<RoomDesign, Map<Door, Optional<RoomDesign>>> getDoorsLayout() {
		// TODO Auto-generated method stub
		return doorsLayoutMap;
	}

}
