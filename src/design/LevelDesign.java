package design;

import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

import design.utilities.enums.Door;
import design.utilities.graphs.BidirectionalGraph;

/**
 * An interface that defines the design aspects of the games levels
 *
 */
public interface LevelDesign {

	/**
	 * @return a linked list containing all the room designs of this level
	 */
	LinkedList<RoomDesign> getRooms();

	/**
	 * @return a bidirectional graph that defines all the connections between rooms
	 *         of this level
	 */
	BidirectionalGraph<RoomDesign> getRoomsGraph();

	/**
	 * @return a map that, for each room of the level, associates to each door the
	 *         connected adjacent room
	 */
	Map<RoomDesign, Map<Door, Optional<RoomDesign>>> getDoorsLayout();

	/**
	 * @param the room design to be added to this level
	 */
	void addRoom(RoomDesign room);

	/**
	 * @param rooms graph of the level
	 */
	void addGraph(BidirectionalGraph<RoomDesign> roomsGraph);

	/**
	 * @param doors layout of the level
	 */
	void addDoorsLayout(Map<RoomDesign, Map<Door, Optional<RoomDesign>>> doorsLayout);
}
