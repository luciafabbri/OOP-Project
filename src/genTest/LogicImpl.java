package genTest;

import org.newdawn.slick.Input;

import levels.Level;

public class LogicImpl {
	
	private Level level;
	
	public LogicImpl(final Level level) {
		this.level = level;
	}
	
	public void switchRooms(final Input input) {
		if(input.isKeyPressed(Input.KEY_RIGHT)) {
			if(level.getRoomID() != level.getLevel().size() - 1) 
				level.setRoomID(level.getRoomID() + 1);
		} else if(input.isKeyPressed(Input.KEY_LEFT)) {
			if(level.getRoomID() != 0)
				level.setRoomID(level.getRoomID() - 1);
		}
	}
}
