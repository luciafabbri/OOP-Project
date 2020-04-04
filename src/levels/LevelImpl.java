package levels;

import java.util.ArrayList;
import java.util.List;

import genTest.GameSettings;

public class LevelImpl implements Level, GameSettings {
	
	private List<RoomImpl> level = new ArrayList<>();
	
	public LevelImpl() {
		this.loadScreen();
	}
	
	@Override
	public void loadScreen() {	
		RoomImpl tmpRoom = new RoomImpl();
		
		//Qui aggiungo solo un livello come test, ma dovrei metterli tutti
		level.add(tmpRoom);
	}

	public List<RoomImpl> getLevel() {
		return level;
	}
}
