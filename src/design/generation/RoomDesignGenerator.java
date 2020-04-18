package design.generation;

import java.util.Map;

import org.newdawn.slick.SlickException;

import design.RoomDesign;

public interface RoomDesignGenerator {

	RoomDesign generateRoom(int index) throws SlickException;
	
}
