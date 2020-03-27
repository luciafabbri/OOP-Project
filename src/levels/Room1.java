package levels;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import genTest.Pair;
import tiles.*;


public class Room1 {

	private Tile floor;
	private Tile wallVert;
	private Tile wallHor;
	private Tile corners;
	private Map<Tile, List<Pair<Integer, Integer>>> items = new LinkedHashMap<>();

	public Room1() {	
		try {
			this.floor = new Floor1();
			this.wallVert = new WallVert1();
			this.wallHor = new WallHor1();
			this.corners = new Corner1();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setItems();
	}
	
	public void setItems() {
		List<Pair<Integer, Integer>> coord = new ArrayList<>();	
		
		coord.add(new Pair<>(48 * 5, 48 * 6)); //TEST ESEMPIO DA CAMBIARE
		
		try {
			items.put(new Tile(new Image("./res/key.png")), coord);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public Tile getFloor() {
		return floor;
	}

	public Map<Tile, List<Pair<Integer, Integer>>> getItems() {
		return items;
	}

	public Tile getWallVert() {
		return wallVert;
	}

	public Tile getWallHor() {
		return wallHor;
	}

	public Tile getCorners() {
		return corners;
	}
}
