package levels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import design.LevelDesign;
import design.generation.LevelDesignGeneratorImpl;

public class LevelImpl implements Level {
	
	private List<RoomImpl> level = new ArrayList<>();
	private LevelDesignGeneratorImpl generator = new LevelDesignGeneratorImpl();
	private LevelDesign testLevel;
	private RoomImpl tmpRoom;
	
	private int roomID;
	
	public LevelImpl(final int levelID) throws IOException {
		testLevel = generator.generateLevel(levelID);			
		this.loadScreen();
	}
	
	@Override
	public void loadScreen() {	
		for(int i = 0; i < testLevel.getRooms().size(); i++) {
			tmpRoom = new RoomImpl(testLevel.getRooms().get(i), testLevel.getDoorsLayout());
			//Qui aggiungo solo un livello come test, ma dovrei metterli tutti
			level.add(tmpRoom);
		}
	}

	public List<RoomImpl> getLevel() {
		return level;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
}
