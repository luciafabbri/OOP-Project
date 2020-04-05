package levels;

import java.util.ArrayList;
import java.util.List;

public class Level1 implements Level {
	
	//LIVELLO FORMATO DA GRAFI DI STANZE PER COLLEGARLE TRA LORO
	private List<Room1> level = new ArrayList<>();
	
	public Level1() {
		this.loadScreenTest();
	}
	
	@Override
	public void loadScreenTest() {	
		Room1 tmpRoom = new Room1();
		
		//Qui aggiungo solo un livello come test, ma dovrei metterli tutti
		level.add(tmpRoom);
	}

	public List<Room1> getLevel() {
		return level;
	}
}
