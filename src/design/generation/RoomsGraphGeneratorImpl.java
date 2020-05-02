package design.generation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import design.RoomDesign;
import design.utilities.*;
import design.utilities.enums.Door;
import design.utilities.graphs.BidirectionalGraph;

/**
 * Implementation of RoomsGraphGenerator interface
 *
 */
public class RoomsGraphGeneratorImpl implements RoomsGraphGenerator {

	private Random random = new Random();

	@Override
	public BidirectionalGraph<RoomDesign> generateRoomsGraph(LinkedList<RoomDesign> rooms) {

		BidirectionalGraph<RoomDesign> graph = new BidirectionalGraph<RoomDesign>();

		// each room is added as a node
		rooms.forEach(r -> {
			graph.addNode(r);
		});

		// for each node/room the random generation process is executed
		graph.getNodes().forEach(n -> {
			// each room has a random number of edges/connection, between 1 and 4
			int numOfRemainingEdges = random.nextInt(GameSettings.MAXDOORS) + GameSettings.MINDOORS;
			// while a room still has edges to "fill", random connections to other rooms
			// that have edges to "fill" themselves are created
			while (graph.getEdges(n).size() < GameSettings.MINDOORS) {
				while (numOfRemainingEdges > 0 && graph.getEdges(n).size() < GameSettings.MAXDOORS) {
					int randomNodeIndex = random.nextInt(rooms.size());
					if (randomNodeIndex != n.getRoomID() && !graph.getEdges(n).contains(rooms.get(randomNodeIndex))) {
						if (graph.getEdges(rooms.get(randomNodeIndex)).size() < GameSettings.MAXDOORS) {
							graph.addEdge(n, rooms.get(randomNodeIndex));
						}
						numOfRemainingEdges--;
					}
				}
			}

		});

		return graph;

	}

	@Override
	public Map<RoomDesign, Map<Door, Optional<RoomDesign>>> generateDoorsLayout(BidirectionalGraph<RoomDesign> graph) {

		Map<RoomDesign, Map<Door, Optional<RoomDesign>>> roomLayout = new HashMap<>();

		// creates a map for each room
		graph.getNodes().forEach(n -> {
			roomLayout.put(n, new HashMap<Door, Optional<RoomDesign>>());
		});

		// rooms can have from 1 to 4 doors, if a room's door is not present, it is
		// associated in the map to an empty optional
		roomLayout.values().forEach(m -> {
			m.put(Door.WEST, Optional.empty());
			m.put(Door.NORTH, Optional.empty());
			m.put(Door.EAST, Optional.empty());
			m.put(Door.SOUTH, Optional.empty());
		});

		// creates bidirectional doors association for all rooms based on cardinality
		graph.getNodes().forEach(n -> {
			roomLayout.keySet().forEach(k -> {
				if (n.equals(k)) {
					graph.getEdges(n).forEach(e -> {
						for (Door d : Door.values()) {
							if (roomLayout.get(k).get(d).isEmpty()
									&& !roomLayout.get(k).values().contains(Optional.of(e))) {
								if (roomLayout.get(e).get(returnOppositeDoor(d)).isEmpty()
										&& !roomLayout.get(e).values().contains(Optional.of(k))) {
									roomLayout.get(k).put(d, Optional.of(e));
									roomLayout.get(e).put(returnOppositeDoor(d), Optional.of(k));

								}
							}
						}
					});
				}
			});
		});

		return roomLayout;
	}

	/**
	 * @param door
	 * @return cardinal opposite door
	 */
	private Door returnOppositeDoor(Door door) {
		if (door.equals(Door.WEST)) {
			return Door.EAST;
		} else if (door.equals(Door.NORTH)) {
			return Door.SOUTH;
		} else if (door.equals(Door.EAST)) {
			return Door.WEST;
		} else if (door.equals(Door.SOUTH)) {
			return Door.NORTH;
		} else {
			throw new IllegalStateException();
		}

	}
}
