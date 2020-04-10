package levels;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.SlickException;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import gameEntities.GameEntity;
import gameEntities.Stairs;
import gameEntities.items.ItemImpl;
import gameEntities.items.Key;
import tiles.*;


public class RoomImpl {

	private Tile floor;
	private Tile wallVert;
	private Tile wallHor;
	private Tile corners;
	private List<Tile> doors = new ArrayList<>();
	private List<ItemImpl> items = new ArrayList<>();
	private List<GameEntity> obst = new ArrayList<>();
	private RoomDesign room;
	
	private Random rand = new Random();
	
	public RoomImpl(final RoomDesign room) {	
		try {
			this.room = room;
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
			int x = 64 * (1 + rand.nextInt(18));
			int y = 64 * (1 + rand.nextInt(11));
			items.add(new Key(new Pair<>(x, y)));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setObstacles() {
		
		obst.add(new Stairs(new Pair<>(64 * 7, 64 * 9)));
	}
	
	public void setDoors(final int numDoors) {
		
		try {
			doors.add(new Door1());
			
			if(numDoors > 2) {
				doors.add(new Door2());
			}
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

	public List<Tile> getDoors() {
		return doors;
	}
}
