package levels;

import java.util.List;

public interface Level {
	
	void loadRooms();
	
	List<RoomImpl> getLevel();

	int getRoomID();
	
	void setRoomID(int roomID);
}