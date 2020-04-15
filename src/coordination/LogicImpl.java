package coordination;

import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Stream;

import org.newdawn.slick.Input;

import design.RoomDesign;
import design.utilities.Door;
import levels.Level;
import player.Player;

public class LogicImpl {
	
	private Level level;
	private Player player;
	
	public LogicImpl(final Level level, final Player player) {
		this.level = level;
		this.player = player;
	}
	
	public void switchRooms(final Input input) {
		if(input.isKeyPressed(Input.KEY_RIGHT) && !level.getLevel().get(level.getRoomID()).getDoorAccess().entrySet().stream().filter(s -> s.getKey().equals(Door.EAST)).findFirst().get().getValue().equals(Optional.empty())) {
			level.setRoomID(level.getLevel().get(level.getRoomID()).getDoorAccess().entrySet().stream().filter(s -> s.getKey().equals(Door.EAST)).findFirst().get().getValue().get().getRoomID());
		} else if(input.isKeyPressed(Input.KEY_LEFT) && !level.getLevel().get(level.getRoomID()).getDoorAccess().entrySet().stream().filter(s -> s.getKey().equals(Door.WEST)).findFirst().get().getValue().equals(Optional.empty())) {
			level.setRoomID(level.getLevel().get(level.getRoomID()).getDoorAccess().entrySet().stream().filter(s -> s.getKey().equals(Door.WEST)).findFirst().get().getValue().get().getRoomID());
		} else if(input.isKeyPressed(Input.KEY_UP) && !level.getLevel().get(level.getRoomID()).getDoorAccess().entrySet().stream().filter(s -> s.getKey().equals(Door.NORTH)).findFirst().get().getValue().equals(Optional.empty())) {
			level.setRoomID(level.getLevel().get(level.getRoomID()).getDoorAccess().entrySet().stream().filter(s -> s.getKey().equals(Door.NORTH)).findFirst().get().getValue().get().getRoomID());
		} else if(input.isKeyPressed(Input.KEY_DOWN) && !level.getLevel().get(level.getRoomID()).getDoorAccess().entrySet().stream().filter(s -> s.getKey().equals(Door.SOUTH)).findFirst().get().getValue().equals(Optional.empty())) {
			level.setRoomID(level.getLevel().get(level.getRoomID()).getDoorAccess().entrySet().stream().filter(s -> s.getKey().equals(Door.SOUTH)).findFirst().get().getValue().get().getRoomID());
		}
		player.setCurrentRoom(level.getLevel().get(level.getRoomID()).getRoom());
	}
	
	public void moveMain(final Input input) {
		player.setPosition(input);
	}
	
	
}

