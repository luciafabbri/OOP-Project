package design.generation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import design.RoomDesign;
import design.utilities.*;

public class RoomsGraphGeneratorImpl implements RoomsGraphGenerator {

	private Random random = new Random();
	
	public BidirectionalGraph<RoomDesign> generateRoomsGraph(LinkedList<RoomDesign> rooms) {

		BidirectionalGraph<RoomDesign> graph = new BidirectionalGraph<RoomDesign>();
		
		rooms.forEach( r -> {
			graph.addNode(r);
		});
		
		graph.getNodes().forEach( n -> {
			
			int numOfRemainingEdges = random.nextInt(GameSettings.MAXDOORS) + GameSettings.MINDOORS; // between 1 and 4 edge
			while(graph.getEdges(n).size() < GameSettings.MINDOORS) {
				while(numOfRemainingEdges > 0 && graph.getEdges(n).size() < GameSettings.MAXDOORS) {
					int randomNodeIndex = random.nextInt(rooms.size());
					if(randomNodeIndex != n.getRoomID() && !graph.getEdges(n).contains(rooms.get(randomNodeIndex))) {
						if(graph.getEdges(rooms.get(randomNodeIndex)).size() < GameSettings.MAXDOORS) {
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
	public Map<RoomDesign, Map<Door, Optional<RoomDesign>>> generateDoorsLayout(
			BidirectionalGraph<RoomDesign> graph) {
		
		Map<RoomDesign, Map<Door, Optional<RoomDesign>>> roomLayout = new HashMap<>();
		
		graph.getNodes().forEach(n -> {
			roomLayout.put(n, new HashMap<Door, Optional<RoomDesign>>());
		});
		
		roomLayout.values().forEach(m -> {
			m.put(Door.WEST, Optional.empty());
			m.put(Door.NORTH, Optional.empty());
			m.put(Door.EAST, Optional.empty());
			m.put(Door.SOUTH, Optional.empty());
		});
		
		graph.getNodes().forEach(n -> {
			roomLayout.keySet().forEach(k -> {
				if(n.equals(k)) {
					graph.getEdges(n).forEach(e -> {
						for(Door d : Door.values()) {
							if(roomLayout.get(k).get(d).isEmpty() && !roomLayout.get(k).values().contains(Optional.of(e))) {
								if(roomLayout.get(e).get(returnOppositeDoor(d)).isEmpty() && !roomLayout.get(e).values().contains(Optional.of(k))){
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
	
	private Door returnOppositeDoor(Door door) {
		if(door.equals(Door.WEST)) {
			return Door.EAST;
		}
		else if(door.equals(Door.NORTH)) {
			return Door.SOUTH;
		}
		else if(door.equals(Door.EAST)) {
			return Door.WEST;
		}
		else if(door.equals(Door.SOUTH)) {
			return Door.NORTH;
		}
		else {
			throw new IllegalStateException();
		}
		
	}
}
