package levels;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import items.*;
import tiles.*;
import utility.Pair;


public class Room1 {

	private Tile floor;
	private Tile wallVert;
	private Tile wallHor;
	private Tile corners;
	private List<ItemImpl> items = new ArrayList<>();

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
		
		try {
			items.add(new Key(new Pair<>(48 * 5, 48 * 7)));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Tile getFloor() {
		return floor;
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

	public List<ItemImpl> getItems() {
		return items;
	}
}
