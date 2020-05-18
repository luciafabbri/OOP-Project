package levels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

import dynamicBody.ImageFactory;
import dynamicBody.character.enemy.creator.TypeEnemy;
import dynamicBody.move.Direction;
import worldModel.LevelModel;
import worldModel.generation.LevelModelGeneratorImpl;
import worldModel.utilities.Pair;

public class LevelCompImpl implements LevelComp {
	
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
	private boolean changedRoom;
	
	public LevelCompImpl(final int levelID) throws IOException {
		testLevel = new LevelModelGeneratorImpl().generateLevel(levelID);
		this.loadRooms();
		this.pauseMenu = false;
		this.roomID = 0;
		this.changedRoom = false;
	}
	
	@Override
	public void loadRooms() {	
		for(int i = 0; i < testLevel.getRooms().size(); i++) {
			tmpRoom = new RoomImpl(testLevel.getRooms().get(i), testLevel.getDoorsLayout());
			
			level.add(tmpRoom);
		}
	}
	
	public Map<TypeEnemy, Set<Pair<Direction, Animation>>> loadAnimations() throws SlickException {
		Map<TypeEnemy, Set<Pair<Direction, Animation>>> tmpMap = new HashMap<>();
		Set<Pair<Direction, Animation>> tmpSet = new HashSet<>();
		
		TypeEnemy temp = this.level.get(this.roomID).getRoom().getEnemySet().iterator().next().getTypeEnemy();
		
		tmpSet.add(new Pair<>(Direction.NORTH, ImageFactory.getAnimation(ImageFactory.getEnemyImage(temp, Direction.NORTH))));
		tmpSet.add(new Pair<>(Direction.EAST, ImageFactory.getAnimation(ImageFactory.getEnemyImage(temp, Direction.EAST))));
		tmpSet.add(new Pair<>(Direction.WEST, ImageFactory.getAnimation(ImageFactory.getEnemyImage(temp, Direction.WEST))));
		tmpSet.add(new Pair<>(Direction.SOUTH, ImageFactory.getAnimation(ImageFactory.getEnemyImage(temp, Direction.SOUTH))));
		
		tmpMap.put(temp, tmpSet);
		
		return tmpMap;
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

	public boolean isChangedRoom() {
		return changedRoom;
	}

	public void setChangedRoom(boolean changedRoom) {
		this.changedRoom = changedRoom;
	}
}
