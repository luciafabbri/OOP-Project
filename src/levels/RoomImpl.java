package levels;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.newdawn.slick.SlickException;

import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import design.utilities.enums.Door;
import gameEntities.Obstacle;
import tiles.*;


public class RoomImpl implements Room {

	/**
	 * Variable containing the RoomDesign associated with the right room
	 */
	private RoomDesign room;
	/**
	 * Variable containing the Map with the door and rooms the current room is connected to
	 */
	private Map<Door, Optional<RoomDesign>> doorAccess;
	
	/**
	 * Variable containing the Tile of the floor
	 */
	private Tile floor;
	/**
	 * Variable containing the Tile of the vertical walls
	 */
	private Tile wallVert;
	/**
	 * Variable containing the Tile of the horizontal walls
	 */
	private Tile wallHor;
	/**
	 * Variable containing the Tile of the corner walls
	 */
	private Tile corners;
	/**
	 * Variable containing the Tile of the top of the vertical door
	 */
	private Tile topDoorVert;
	/**
	 * Variable containing the Tile of the top of the horizontal door
	 */
	private Tile topDoorHor;
		
	/**
	 * Variable containing the AnimatedTile, so the animation of the west room
	 */
	private AnimatedTile doorWest;
	/**
	 * Variable containing the AnimatedTile, so the animation of the north room
	 */
	private AnimatedTile doorNorth;
	/**
	 * Variable containing the AnimatedTile, so the animation of the east room
	 */
	private AnimatedTile doorEast;
	/**
	 * Variable containing the AnimatedTile, so the animation of the south room
	 */
	private AnimatedTile doorSouth;
	private boolean gotRoomKey;
	
	
	public RoomImpl(final RoomDesign room, Map<RoomDesign, Map<Door, Optional<RoomDesign>>> doorAccess) {	
		this.room = room;
		this.doorAccess = doorAccess.entrySet().stream().filter(s -> s.getKey().getRoomID() == room.getRoomID()).findFirst().get().getValue();
		this.gotRoomKey = false;
		
		
		try {
			
			this.room.addObstacle(new Obstacle(new Pair<>(GameSettings.WIDTH / 2 - GameSettings.TILESIZE, GameSettings.TILESIZE * 2)));
			this.room.addObstacle(new Obstacle(new Pair<>(GameSettings.LIMITRIGHT - GameSettings.TILESIZE * 2, GameSettings.HEIGHT / 2 - GameSettings.TILESIZE)));
			this.room.addObstacle(new Obstacle(new Pair<>(GameSettings.WIDTH / 2 - GameSettings.TILESIZE, GameSettings.HEIGHT - GameSettings.TILESIZE * 3)));
			this.room.addObstacle(new Obstacle(new Pair<>(GameSettings.TILESIZE * 2, GameSettings.HEIGHT / 2 - GameSettings.TILESIZE)));
			
			
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
	
	@Override
	public Tile getFloor() {
		return floor;
	}

	@Override
	public Tile getWallVert() {
		return wallVert;
	}

	@Override
	public Tile getWallHor() {
		return wallHor;
	}

	@Override
	public Tile getCorners() {
		return corners;
	}

	@Override
	public Map<Door, Optional<RoomDesign>> getDoorAccess() {
		return doorAccess;
	}

	@Override
	public RoomDesign getRoom() {
		return room;
	}

	@Override
	public AnimatedTile getDoorWest() {
		return doorWest;
	}

	@Override
	public AnimatedTile getDoorNorth() {
		return doorNorth;
	}

	@Override
	public AnimatedTile getDoorEast() {
		return doorEast;
	}

	@Override
	public AnimatedTile getDoorSouth() {
		return doorSouth;
	}

	@Override
	public Tile getTopDoorVert() {
		return topDoorVert;
	}

	@Override
	public Tile getTopDoorHor() {
		return topDoorHor;
	}

	public boolean isGotRoomKey() {
		return gotRoomKey;
	}

	public void setGotRoomKey(boolean gotRoomKey) {
		this.gotRoomKey = gotRoomKey;
	}

}
