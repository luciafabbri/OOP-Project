package levels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import worldModel.LevelModel;
import worldModel.generation.LevelModelGeneratorImpl;

public class LevelImpl implements Level {
	
	/**
	 * Variable containing the List of the rooms of the level
	 */
	private List<RoomImpl> level = new ArrayList<>();
	/**
	 * Variable containing the general barebone worldModel of each room
	 */
	private LevelModel testLevel;
	/**
	 * Variable containing temporarly data of each room when adding it to the list
	 */
	private RoomImpl tmpRoom;
	/**
	 * Variable containing ID of the current room loaded 
	 */
	private int roomID;
	private boolean gotLevelCoin;
	private boolean pauseMenu;
	
	public LevelImpl(final int levelID) throws IOException {
		testLevel = new LevelModelGeneratorImpl().generateLevel(levelID);
		this.loadRooms();
		this.pauseMenu = false;
		this.roomID = 0;
	}
	
	@Override
	public void loadRooms() {	
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

	public boolean isGotLevelCoin() {
		return gotLevelCoin;
	}

	public void setGotLevelCoin(boolean gotLevelCoin) {
		this.gotLevelCoin = gotLevelCoin;
	}

	public boolean isPauseMenu() {
		return pauseMenu;
	}

	public void setPauseMenu(boolean pauseMenu) {
		this.pauseMenu = pauseMenu;
	}
}
