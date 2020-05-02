package design.generation;

import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

import design.RoomDesign;
import design.utilities.enums.Door;
import design.utilities.graphs.BidirectionalGraph;

/**
 * Interface defining the methods to map the rooms' layout within a level
 *
 */
public interface RoomsGraphGenerator {

	/**
	 * @param List of rooms of a level
	 * @return randomly generated bidirectional graph, where the level's rooms are
	 *         the nodes and the connection between rooms are the edges
	 */
	BidirectionalGraph<RoomDesign> generateRoomsGraph(LinkedList<RoomDesign> rooms);

	/**
	 * 
	 * @param graph of a level's room layout
	 * @return a Map that associates each room of the level to another map linking
	 *         each room's door(NORTH, SOUTH, EAST, WEST) to the connected room in a
	 *         way that is consistent with a three dimensional world. Consistent
	 *         means that bidirectionality is guaranteed for any connection: if A
	 *         room has NORTH door connected to room B, room B has SOUTH door
	 *         connected to room A.
	 */
	Map<RoomDesign, Map<Door, Optional<RoomDesign>>> generateDoorsLayout(BidirectionalGraph<RoomDesign> graph);
}
