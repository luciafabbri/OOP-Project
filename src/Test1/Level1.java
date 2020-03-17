package Test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Level1 implements LevelTestInterface {
	
	//LIVELLO FORMATO DA GRAFI DI STANZE PER COLLEGARLE TRA LORO
	private List<Room> level = new ArrayList<>();
	
	public Level1() {
		this.loadScreenTest();
	}
	
	@Override
	public void loadScreenTest() {
		List<TileTestImpl> tmp2 = new ArrayList<>();
		
		try {
		
			tmp2.add(new TileTestImpl(new Image("./res/floor_1.png"), true));
			tmp2.add(new TileTestImpl(new Image("./res/wall_inner_corner_mid_left.png"), true));
			tmp2.add(new TileTestImpl(new Image("./res/wall_inner_corner_mid_rigth.png"), true));
			tmp2.add(new TileTestImpl(new Image("./res/wall_inner_corner_mid_up.png"), true));
			tmp2.add(new TileTestImpl(new Image("./res/wall_inner_corner_mid_down.png"), true));
			
			tmp2.add(new TileTestImpl(new Image("./res/wall_inner_corner_mid_bottom_left.png"), true));
			tmp2.add(new TileTestImpl(new Image("./res/wall_inner_corner_mid_bottom_right.png"), true));
			tmp2.add(new TileTestImpl(new Image("./res/wall_inner_corner_mid_top_left.png"), true));
			tmp2.add(new TileTestImpl(new Image("./res/wall_inner_corner_mid_top_right.png"), true));
	
		} catch(SlickException e) {
			Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, e);
		}
	
		Room tmpRoom = new Room(WIDTH, HEIGHT, TILESIZE, tmp2);
		
		//Qui aggiungo solo un livello come test, ma dovrei metterli tutti
		level.add(tmpRoom);
	}
	
	public Map<TileTestImpl, List<Pair<Integer, Integer>>> getRoom(){
		
		//Qui ci starebbe appunto utilizzare l'idea dei grafi con nodi per gli identificativi per capire quale stanza caricare
		return this.level.get(0).getRoom();
	}

}
