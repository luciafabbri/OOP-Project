package levels;

import java.util.Map;
import java.util.Optional;

import design.RoomDesign;
import design.utilities.enums.Door;
import tiles.AnimatedTile;
import tiles.Tile;

public interface Room {

	/**
	 * method that returns the tiles regarding the floor
	 * @return Tile, the floor tiles
	 */
	Tile getFloor();

	/**
	 * method that returns the tiles regarding the vertical walls
	 * @return Tile, the vertical walls tiles
	 */
	Tile getWallVert();

	/**
	 * method that returns the tiles regarding the horizontal floor
	 * @return Tile, the horizontal wall tiles
	 */
	Tile getWallHor();

	/**
	 * method that returns the tiles regarding the four corners
	 * @return Tile, the corners of the walls
	 */
	Tile getCorners();

	/**
	 * method that returns the Map with the existing doors, based on which rooms are connected which
	 * @return Map, with the value being other RoomDesigns that can exist, which is associated with a Door
	 */
	Map<Door, Optional<RoomDesign>> getDoorAccess();

	/**
	 * method that returns the RoomDesign of the current room
	 * @return RoomDesign, containing the current room entities and objects
	 */
	RoomDesign getRoom();

	/**
	 * method that returns the animated tiles with the western door
	 * @return AnimatedTile
	 */
	AnimatedTile getDoorWest();

	/**
	 * method that returns the animated tiles with the northren door
	 * @return AnimatedTile
	 */
	AnimatedTile getDoorNorth();

	/**
	 * method that returns the animated tiles with the eastern door
	 * @return AnimatedTile
	 */
	AnimatedTile getDoorEast();

	/**
	 * method that returns the animated tiles with the southern door
	 * @return AnimatedTile
	 */
	AnimatedTile getDoorSouth();

	/**
	 * Method that returns the tiles of the vertical top of the door
	 * @return Tile, the vertical top of the door
	 */
	Tile getTopDoorVert();

	/**
	 * Method that returns the tiles of the horizontal top of the door
	 * @return Tile, the horizontal top of the door
	 */
	Tile getTopDoorHor();

}