package Test1;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GraphicsImpl implements GraphicsInterfaceTest {
	
	private Map<TileTestImpl, List<Pair<Integer, Integer>>> room;
	
	public GraphicsImpl(final Map<TileTestImpl, List<Pair<Integer, Integer>>> map) {
		this.room = map;
	}
	
	@Override
	public void drawRoom() {
		for(Entry<TileTestImpl, List<Pair<Integer, Integer>>> entry : room.entrySet()) {
			for(int i = 0; i < entry.getValue().size(); i++) {
				
				
				int x = entry.getValue().get(i).getX();
				int y = entry.getValue().get(i).getY();
				entry.getKey().getTexture().draw(x, y, TILESIZE, TILESIZE);
			}
		}
	}
}
