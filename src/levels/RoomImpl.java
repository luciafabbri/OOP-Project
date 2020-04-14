package levels;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;

import org.newdawn.slick.SlickException;

import design.RoomDesign;
import design.utilities.Door;
import design.utilities.GameSettings;
import design.utilities.Pair;
import gameEntities.GameEntity;
import gameEntities.Stairs;
import gameEntities.items.ItemImpl;
import gameEntities.items.Key;
import tiles.*;


public class RoomImpl {

	private RoomDesign room;
	private Map<Door, Optional<RoomDesign>> doorAccess;
	private Random rand = new Random();
	
	//Room Objects
	private Tile floor;
	private Tile wallVert;
	private Tile wallHor;
	private Tile doorVert;
	private Tile doorHor;
	private Tile corners;
	private List<ItemImpl> items = new ArrayList<>();
	private List<GameEntity> obst = new ArrayList<>();
	
	
	public RoomImpl(final RoomDesign room, Map<RoomDesign, Map<Door, Optional<RoomDesign>>> doorAccess) {	
		this.room = room;
		this.doorAccess = doorAccess.entrySet().stream().filter(s -> s.getKey().getRoomID() == room.getRoomID()).findFirst().get().getValue();
		
		try {
			this.floor = new Floor1();
			this.wallVert = new WallVert1();
			this.wallHor = new WallHor1();
			this.corners = new Corner1();
			this.doorVert = new Door1();
			this.doorHor = new Door2();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setItems();
	}
	
	private void setItems() {
		
		try {
			int x = 64 * (1 + rand.nextInt(18));
			int y = 64 * (1 + rand.nextInt(10));
			items.add(new Key(new Pair<>(x, y)));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setObstacles() {
		
		obst.add(new Stairs(new Pair<>(64 * 7, 64 * 9)));
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

	public Map<Door, Optional<RoomDesign>> getDoorAccess() {
		return doorAccess;
	}

	public Tile getDoorVert() {
		return doorVert;
	}

	public Tile getDoorHor() {
		return doorHor;
	}

	public RoomDesign getRoom() {
		return room;
	}
}
