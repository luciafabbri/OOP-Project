package design;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import design.generation.LevelDesignGeneratorImpl;
import design.utilities.BidirectionalGraph;
import design.utilities.Door;
import design.utilities.Pair;

public class GenerationTest {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		LevelDesignGeneratorImpl generator = new LevelDesignGeneratorImpl();
		
		LevelDesign testLevel = generator.generateLevel(1);
		
		
		testLevel.getRooms().forEach(r -> {
			System.out.println(r.toString() + "has ID : " + r.getRoomID());
			System.out.print("Occupied tiles are the following: ");
			
			r.getOccupiedTiles().forEach(t -> {
				System.out.print(t.toString()+ " ");
			});
			System.out.println("");
			
			System.out.print("Enemies are the following: ");
			
			r.getEnemySet().forEach(e -> {
				System.out.print(e.toString()+ " ");
			});
			System.out.println("");
			System.out.print("World objects are the following: ");
			
			r.getWorldObjectsSet().forEach(t -> {
				System.out.print(t.toString()+ " ");
			});
			System.out.println("");
			System.out.print("Obstacles are the following: ");
			
			r.getObstacleSet().forEach(t -> {
				System.out.print(t.toString()+ " ");
			});
			System.out.println("");
			System.out.println("");
		});
		
		BidirectionalGraph<RoomDesign> graph = testLevel.getRoomsGraph();
		
		System.out.println("Room graph: ");
		for(RoomDesign r : graph.getNodes()) {
			System.out.print("Room " + r.getRoomID()+ " has connections to rooms: ");
			for(RoomDesign a : graph.getEdges(r)) {
				System.out.print(a.getRoomID() + " ");
			}
			System.out.println("");
		}
		
		Map<RoomDesign, Map<Door, Optional<RoomDesign>>> layout = testLevel.getDoorsLayout();
		
		for(RoomDesign d : layout.keySet()) {
			System.out.println("Key: " + d.getRoomID());
			System.out.print(" has doors: ");
			for(Entry<Door, Optional<RoomDesign>> e : layout.get(d).entrySet()) {
				if(e.getValue().isPresent()) {
					System.out.print(e.getKey().toString() + " " + e.getValue().get().getRoomID() + ", ");
				} else {
					System.out.print(e.getKey().toString() + " " +  e.getValue() + ", ");
				}
				
			}
			System.out.println("");
		}
		
		/*
		// tilegraph for a given room printer 
		testLevel.getRooms().get(0).getObstacleSet().forEach( o -> {
			System.out.println("Obstacle in pos: " + o.getPosition());
		});
		
		BidirectionalGraph<Pair <Integer, Integer>> tileGraph = testLevel.getRooms().get(0).getTilesGraph();
		
		System.out.println("Room graph: ");
		for(Pair <Integer, Integer> t : tileGraph.getNodes()) {
			System.out.print("Tile " + t + " has connections to tiles: ");
			for(Pair <Integer, Integer> next : tileGraph.getEdges(t)) {
				System.out.print(next + " ");
			}
			System.out.println("");
		}
		*/
		
	}
}
