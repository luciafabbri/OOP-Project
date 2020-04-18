package design.generation;

import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

import design.RoomDesign;
import design.utilities.BidirectionalGraph;
import design.utilities.Door;

public interface RoomsGraphGenerator {

	BidirectionalGraph<RoomDesign> generateRoomsGraph(LinkedList<RoomDesign> rooms);

	Map<RoomDesign, Map<Door, Optional<RoomDesign>>> generateDoorsLayout(BidirectionalGraph<RoomDesign> graph);
}
