package design;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import coordination.TestPlay;
import coordination.TestState;

import java.util.Optional;

import design.generation.LevelDesignGeneratorImpl;
import design.utilities.BidirectionalGraph;
import design.utilities.Door;
import design.utilities.GameSettings;

public class GenerationTest implements Game {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		//Set the path for Slick2D libraries
		System.setProperty("java.library.path", new File("./lib/libraries").getAbsolutePath());
		
		//Set the path for Slick2D natives
		System.setProperty("org.lwjgl.librarypath", new File("./lib/natives").getAbsolutePath());
		
		//Set the path for JInput
		System.setProperty("net.java.games.input.librarypath", new File("./lib/natives").getAbsolutePath());
		
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new GenerationTest());
			appgc.setDisplayMode(GameSettings.WIDTH, GameSettings.HEIGHT, false);
			appgc.setShowFPS(false);
//			appgc.setVSync(true);
			appgc.setMaximumLogicUpdateInterval(80);
			appgc.start();
		} catch (SlickException e) {
			Logger.getLogger(TestPlay.class.getName()).log(Level.SEVERE, null, e);
		}
		

	}

	@Override
	public boolean closeRequested() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		LevelDesignGeneratorImpl generator = new LevelDesignGeneratorImpl();
		
		LevelDesign testLevel = null;
		try {
			testLevel = generator.generateLevel(1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
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
			System.out.print("Entities are the following: ");
			
			r.getEntitiesSet().forEach(i -> {
				System.out.print(i.toString()+ " ");
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
		
		
		// tilegraph for a given room printer 
		testLevel.getRooms().get(0).getObstacleSet().forEach( o -> {
			System.out.println("Obstacle in pos: " + o.getPosition());
		});
		/*
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
		
		/*
		// stairs generation test
		Long num = testLevel.getRooms().stream().filter(r -> r.areStairsPresent()).map(r -> r.getRoomID()).count();
		System.out.println("Rooms with stairs are: " + num);
		*/
		
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		arg0.exit();
	}
}
