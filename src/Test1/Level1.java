package Test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.newdawn.slick.Image;

public class Level1 implements LevelTestInterface {
	
	//LIVELLO FORMATO DA GRAFI DI STANZE PER COLLEGARLE TRA LORO
	private List<Room1> level = new ArrayList<>();
	
	public Level1() {
		this.loadScreenTest();
	}
	
	@Override
	public void loadScreenTest() {
		
		Room1 tmpRoom = new Room1(WIDTH, HEIGHT, TILESIZE);
		
		//Qui aggiungo solo un livello come test, ma dovrei metterli tutti
		level.add(tmpRoom);
	}
	
	public Map<Image, List<Pair<Integer, Integer>>> getRoom(){
		
		//Qui ci starebbe appunto utilizzare l'idea dei grafi con nodi per gli identificativi per capire quale stanza caricare
		return this.level.get(0).getRoom();
	}

}
