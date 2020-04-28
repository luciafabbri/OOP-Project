package levels;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.newdawn.slick.SlickException;

import design.RoomDesign;
import design.utilities.Pair;
import design.utilities.enums.Door;
import tiles.*;


public class RoomImpl {

	private RoomDesign room;
	private Map<Door, Optional<RoomDesign>> doorAccess;
	
	//Room Objects
	private Tile floor;
	private Tile wallVert;
	private Tile wallHor;
	private Tile corners;
	private Tile topDoorVert;
	private Tile topDoorHor;
		
	private Set<AnimatedTile> doorAnimation;
	private AnimatedTile doorWest;
	private AnimatedTile doorNorth;
	private AnimatedTile doorEast;
	private AnimatedTile doorSouth;
	
	public RoomImpl(final RoomDesign room, Map<RoomDesign, Map<Door, Optional<RoomDesign>>> doorAccess) {	
		this.room = room;
		this.doorAccess = doorAccess.entrySet().stream().filter(s -> s.getKey().getRoomID() == room.getRoomID()).findFirst().get().getValue();
		try {
			
			this.floor = new Floor1();
			this.wallVert = new WallVert1();
			this.wallHor = new WallHor1();
			this.corners = new Corner1();
		
			this.topDoorVert = new DoorTop1();
			this.topDoorHor = new DoorTop2();
					
			this.doorWest = new DoorWest();
			this.doorNorth = new DoorNorth();
			this.doorEast = new DoorEast();
			this.doorSouth = new DoorSouth();
			
			
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

	public Map<Door, Optional<RoomDesign>> getDoorAccess() {
		return doorAccess;
	}

	public RoomDesign getRoom() {
		return room;
	}

	public AnimatedTile getDoorWest() {
		return doorWest;
	}

	public AnimatedTile getDoorNorth() {
		return doorNorth;
	}

	public AnimatedTile getDoorEast() {
		return doorEast;
	}

	public AnimatedTile getDoorSouth() {
		return doorSouth;
	}

	public Tile getTopDoorVert() {
		return topDoorVert;
	}

	public Tile getTopDoorHor() {
		return topDoorHor;
	}

}
