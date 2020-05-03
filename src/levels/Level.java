package levels;

import java.util.List;

public interface Level {
	
	/**
	 * Method that creates a List of RoomImpl that contain the information of each room of the level
	 */
	void loadRooms();
	
	/**
	 * Method that returns the list created with loadRomms
	 * @return List<RoomImpl>, the list of rooms that make up the level
	 */
	List<RoomImpl> getLevel();

	/**
	 * Method that returns the ID of the current loaded room
	 * @return int, the ID of the room
	 */
	int getRoomID();
	
	/**
	 * Method that sets the current room loaded
	 * @param roomID, the room ID that should be loaded
	 */
	void setRoomID(int roomID);
}