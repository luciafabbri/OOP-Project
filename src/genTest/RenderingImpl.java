package genTest;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import design.utilities.GameSettings;
import gameEntities.items.ItemImpl;
import levels.Level;

public class RenderingImpl implements Rendering {
	
	private Level level;
	
	public RenderingImpl(final Level level) {
		this.level = level;
	}
	
	@Override
	public void drawItems() {
		for(int i = 0; i < level.getLevel().get(0).getItems().size(); i++) {
			
			int x = level.getLevel().get(level.getRoomID()).getItems().get(i).getCoord().getX();
			int y = level.getLevel().get(level.getRoomID()).getItems().get(i).getCoord().getY();
			level.getLevel().get(level.getRoomID()).getItems().get(0).getTexture().draw(x, y, 64, 64);
		}
	}
	
	public void drawFloor() {
		for(int x = 0; x < GameSettings.WIDTH; x += GameSettings.TILESIZE) {
			for(int y = 0; y < GameSettings.HEIGHT; y += GameSettings.TILESIZE) {
				level.getLevel().get(level.getRoomID()).getFloor().getTexture().draw(x, y, GameSettings.TILESIZE, GameSettings.TILESIZE);
			}
		}
	}
	
	
	public void drawWalls() {
		//Based on the position, it draws the appropriate walls
		for(int x = 0; x < GameSettings.WIDTH; x += GameSettings.TILESIZE) {
			for(int y = 0; y < GameSettings.HEIGHT; y += GameSettings.TILESIZE) {
				if(x == 0 && y > 0 && y < GameSettings.HEIGHT - GameSettings.TILESIZE) {
					level.getLevel().get(level.getRoomID()).getWallVert().getTexture().draw(x, y, GameSettings.TILESIZE, GameSettings.TILESIZE);
				} else if(x == GameSettings.WIDTH - GameSettings.TILESIZE && y > 0 && y < GameSettings.HEIGHT - GameSettings.TILESIZE) {
					level.getLevel().get(level.getRoomID()).getWallVert().getTexture().getFlippedCopy(true, false).draw(x, y, GameSettings.TILESIZE, GameSettings.TILESIZE);
				} else if(y == 0 && x > 0 && x < GameSettings.WIDTH - GameSettings.TILESIZE) {
					level.getLevel().get(level.getRoomID()).getWallHor().getTexture().getFlippedCopy(false, true).draw(x, y, GameSettings.TILESIZE, GameSettings.TILESIZE);
				} else if(y == GameSettings.HEIGHT - GameSettings.TILESIZE && x > 0 && x < GameSettings.WIDTH - GameSettings.TILESIZE) {
					level.getLevel().get(level.getRoomID()).getWallHor().getTexture().draw(x, y, GameSettings.TILESIZE, GameSettings.TILESIZE);
				}
			}
		}
		
		//Here a draw the corners, since they're always in the same position (the corners), I don't need to draw the dinamically
		level.getLevel().get(level.getRoomID()).getCorners().getTexture().draw(0, 0, GameSettings.TILESIZE, GameSettings.TILESIZE);
		level.getLevel().get(level.getRoomID()).getCorners().getTexture().getFlippedCopy(false, true).draw(0, GameSettings.HEIGHT - GameSettings.TILESIZE, GameSettings.TILESIZE, GameSettings.TILESIZE);
		level.getLevel().get(level.getRoomID()).getCorners().getTexture().getFlippedCopy(true, false).draw(GameSettings.WIDTH - GameSettings.TILESIZE, 0, GameSettings.TILESIZE, GameSettings.TILESIZE);
		level.getLevel().get(level.getRoomID()).getCorners().getTexture().getFlippedCopy(true, true).draw(GameSettings.WIDTH - GameSettings.TILESIZE, GameSettings.HEIGHT - GameSettings.TILESIZE, GameSettings.TILESIZE, GameSettings.TILESIZE);
	}
	
}
