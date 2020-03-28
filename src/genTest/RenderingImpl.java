package genTest;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import items.ItemImpl;
import levels.Level;

public class RenderingImpl implements Rendering {
	
	private Level level;
	
	public RenderingImpl(final Level level) {
		this.level = level;
	}
	
	@Override
	public void drawItems() {
		for(int i = 0; i < level.getLevel().get(0).getItems().size(); i++) {
			
			int x = level.getLevel().get(0).getItems().get(i).getCoord().getX();
			int y = level.getLevel().get(0).getItems().get(i).getCoord().getY();
			level.getLevel().get(0).getItems().get(0).getTexture().draw(x, y, TILESIZE, TILESIZE);
		}
	}
	
	public void drawFloor() {
		for(int x = 0; x < WIDTH; x += TILESIZE) {
			for(int y = 0; y < HEIGHT; y += TILESIZE) {
				level.getLevel().get(0).getFloor().getTexture().draw(x, y, TILESIZE, TILESIZE);
			}
		}
	}
	
	
	public void drawWalls() {
		//Based on the position, it draws the appropriate walls
		for(int x = 0; x < WIDTH; x += TILESIZE) {
			for(int y = 0; y < HEIGHT; y += TILESIZE) {
				if(x == 0 && y > 0 && y < HEIGHT - TILESIZE) {
					level.getLevel().get(0).getWallVert().getTexture().draw(x, y, TILESIZE, TILESIZE);
				} else if(x == WIDTH - TILESIZE && y > 0 && y < HEIGHT - TILESIZE) {
					level.getLevel().get(0).getWallVert().getTexture().getFlippedCopy(true, false).draw(x, y, TILESIZE, TILESIZE);
				} else if(y == 0 && x > 0 && x < WIDTH - TILESIZE) {
					level.getLevel().get(0).getWallHor().getTexture().getFlippedCopy(false, true).draw(x, y, TILESIZE, TILESIZE);
				} else if(y == HEIGHT - TILESIZE && x > 0 && x < WIDTH - TILESIZE) {
					level.getLevel().get(0).getWallHor().getTexture().draw(x, y, TILESIZE, TILESIZE);
				}
			}
		}
		
		//Here a draw the corners, since they're always in the same position (the corners), I don't need to draw the dinamically
		level.getLevel().get(0).getCorners().getTexture().draw(0, 0, TILESIZE, TILESIZE);
		level.getLevel().get(0).getCorners().getTexture().getFlippedCopy(false, true).draw(0, HEIGHT - TILESIZE, TILESIZE, TILESIZE);
		level.getLevel().get(0).getCorners().getTexture().getFlippedCopy(true, false).draw(WIDTH - TILESIZE, 0, TILESIZE, TILESIZE);
		level.getLevel().get(0).getCorners().getTexture().getFlippedCopy(true, true).draw(WIDTH - TILESIZE, HEIGHT - TILESIZE, TILESIZE, TILESIZE);
	}
	
	
	
}
