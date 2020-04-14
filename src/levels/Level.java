package levels;

import java.util.List;

public interface Level {
	
	void loadScreen();
	
	List<RoomImpl> getLevel();

	int getRoomID();
	
	void setRoomID(int roomID);
}