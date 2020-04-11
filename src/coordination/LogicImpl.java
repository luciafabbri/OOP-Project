package coordination;

import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Stream;

import org.newdawn.slick.Input;

import design.RoomDesign;
import design.utilities.Door;
import levels.Level;

public class LogicImpl {
	
	private Level level;
	
	public LogicImpl(final Level level) {
		this.level = level;
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
		
	}
}

