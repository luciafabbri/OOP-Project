package coordination;

import org.newdawn.slick.Input;

import design.utilities.GameSettings;
import design.utilities.Pair;
import design.utilities.enums.Door;
import levels.Level;
import player.Player;
import utility.DoorCheck;

public class LogicImpl {
	
	private Level level;
	private Player player;
	
	public LogicImpl(final Level level, final Player player) {
		this.level = level;
		this.player = player;
	}
	
	public void switchRooms(final Input input) {
		DoorCheck check = new DoorCheck();
		
		if( (check.transEast(player.getPosition()) || input.isKeyPressed(Input.KEY_RIGHT)) && checkEmpty(Door.EAST)) {
			level.setRoomID(getRoomID(Door.EAST));
			player.setPosition(new Pair<>(GameSettings.TILESIZE, GameSettings.TILESIZE * 5 - GameSettings.TILESIZE / 2));
		} else if((check.transWest(player.getPosition()) || input.isKeyPressed(Input.KEY_LEFT)) && checkEmpty(Door.WEST)) {
			level.setRoomID(getRoomID(Door.WEST));
			player.setPosition(new Pair<>(GameSettings.LIMITRIGHT - GameSettings.TILESIZE, GameSettings.TILESIZE * 5 - GameSettings.TILESIZE / 2));
		} else if((check.transNorth(player.getPosition()) || input.isKeyPressed(Input.KEY_UP)) && checkEmpty(Door.NORTH)) {
			level.setRoomID(getRoomID(Door.NORTH));
			player.setPosition(new Pair<>(GameSettings.TILESIZE * 9, GameSettings.LIMITDOWN - GameSettings.TILESIZE));
		} else if((check.transSouth(player.getPosition()) || input.isKeyPressed(Input.KEY_DOWN)) && checkEmpty(Door.SOUTH)) {
			level.setRoomID(getRoomID(Door.SOUTH));
			player.setPosition(new Pair<>(GameSettings.TILESIZE * 9, GameSettings.TILESIZE));
		}
		player.setCurrentRoom(level.getLevel().get(level.getRoomID()).getRoom());
	}
	
	public void moveMain(final Input input) {
		player.setPosition(input, level);
	}
	
	private boolean checkEmpty(final Door door) {
		return level.getLevel().get(level.getRoomID()).getDoorAccess().entrySet().stream().filter(s -> s.getKey().equals(door)).findFirst().get().getValue().isPresent();
	}
	
	private int getRoomID(final Door door) {
		return level.getLevel().get(level.getRoomID()).getDoorAccess().entrySet().stream().filter(s -> s.getKey().equals(door)).findFirst().get().getValue().get().getRoomID();
	}
	
}

