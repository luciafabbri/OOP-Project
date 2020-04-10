package design;

import java.io.IOException;

import design.utilities.BidirectionalGraph;

public class Test {
	
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
		
		
	}
}
