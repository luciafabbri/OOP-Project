package design;

import java.util.LinkedList;

public class LevelDesignImpl implements LevelDesign {

	LinkedList<RoomDesign> rooms = new LinkedList<>();

	public void addRoom(RoomDesign room) {
		rooms.add(room);
	}
	
}
