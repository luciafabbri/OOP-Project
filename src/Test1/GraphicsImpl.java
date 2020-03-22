package Test1;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.newdawn.slick.Image;

public class GraphicsImpl implements GraphicsInterfaceTest {
	
	private Map<Image, List<Pair<Integer, Integer>>> room;
	
	public GraphicsImpl(final Map<Image, List<Pair<Integer, Integer>>> map) {
		this.room = map;
	}
	
	@Override
	public void drawRoom() {
		for(Entry<Image, List<Pair<Integer, Integer>>> entry : room.entrySet()) {
			for(int i = 0; i < entry.getValue().size(); i++) {
				
				
				int x = entry.getValue().get(i).getX();
				int y = entry.getValue().get(i).getY();
				entry.getKey().draw(x, y, TILESIZE, TILESIZE);
			}
		}
	}
}
