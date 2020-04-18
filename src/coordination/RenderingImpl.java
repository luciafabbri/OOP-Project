package coordination;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import design.RoomDesign;
import design.utilities.Door;
import design.utilities.GameSettings;
import design.utilities.Pair;
import gameEntities.Obstacle;
import gameEntities.items.ItemImpl;
import levels.Level;
import player.Player;
import tiles.Tile;
import utility.Direction;

public class RenderingImpl implements Rendering {
	
	private Level level;
	private Player player;
	
	public RenderingImpl(final Level level, final Player player) {
		this.level = level;
		this.player = player;
	}
	
	public void drawMain(final Input input) {
		if(this.player.getDirection().equals(Direction.SOUTH)) {
			if(input.isKeyDown(Input.KEY_S) ) {
				this.player.getFront().draw(this.player.getPosition().getX(), this.player.getPosition().getY(), GameSettings.TILESIZE, GameSettings.TILESIZE);
			} else {
				this.player.getFront().setCurrentFrame(0);
				this.player.getFront().getCurrentFrame().draw(this.player.getPosition().getX(), this.player.getPosition().getY(), GameSettings.TILESIZE, GameSettings.TILESIZE);
			}
		} else if(this.player.getDirection().equals(Direction.NORTH)) {
			if(input.isKeyDown(Input.KEY_W) ) {
				this.player.getBack().draw(this.player.getPosition().getX(), this.player.getPosition().getY(), GameSettings.TILESIZE, GameSettings.TILESIZE);
			} else {
				this.player.getBack().setCurrentFrame(0);
				this.player.getBack().getCurrentFrame().draw(this.player.getPosition().getX(), this.player.getPosition().getY(), GameSettings.TILESIZE, GameSettings.TILESIZE);
			}
		} else if(this.player.getDirection().equals(Direction.EAST)) {
			if(input.isKeyDown(Input.KEY_D) ) {
				this.player.getRight().draw(this.player.getPosition().getX(), this.player.getPosition().getY(), GameSettings.TILESIZE, GameSettings.TILESIZE);
			} else {
				this.player.getRight().setCurrentFrame(0);
				this.player.getRight().getCurrentFrame().draw(this.player.getPosition().getX(), this.player.getPosition().getY(), GameSettings.TILESIZE, GameSettings.TILESIZE);
			}
		} else if(this.player.getDirection().equals(Direction.WEST)) {
			if(input.isKeyDown(Input.KEY_A) ) {
				this.player.getLeft().draw(this.player.getPosition().getX(), this.player.getPosition().getY(), GameSettings.TILESIZE, GameSettings.TILESIZE);
			} else {
				this.player.getLeft().setCurrentFrame(0);
				this.player.getLeft().getCurrentFrame().draw(this.player.getPosition().getX(), this.player.getPosition().getY(), GameSettings.TILESIZE, GameSettings.TILESIZE);
			}
		}
	}
	
	public void drawObstacles() {
		
		Set<Pair<Integer, Integer>> tmp = this.level.getLevel().get(level.getRoomID()).getRoom().getObstaclePositions();
		try {
			Image texture = new Image("./res/obstacles/obstacle_stone1.png");
			
			for(int i = 0; i < tmp.size(); i++) {
				tmp.forEach(s -> texture.draw(s.getX(), s.getY(), GameSettings.TILESIZE, GameSettings.TILESIZE) );	
			}
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void drawItems() {
		for(int i = 0; i < level.getLevel().get(level.getRoomID()).getItems().size(); i++) {
			
			int x = level.getLevel().get(level.getRoomID()).getItems().get(i).getPosition().getX();
			int y = level.getLevel().get(level.getRoomID()).getItems().get(i).getPosition().getY();
			level.getLevel().get(level.getRoomID()).getItems().get(i).getTexture().draw(x, y, 64, 64);
		}
		
	}
	
	public void drawMod() {
		for(int i = 0; i < level.getLevel().get(level.getRoomID()).getMod().size(); i++) {
			
			int x = level.getLevel().get(level.getRoomID()).getMod().get(i).getPosition().getX();
			int y = level.getLevel().get(level.getRoomID()).getMod().get(i).getPosition().getY();
			level.getLevel().get(level.getRoomID()).getMod().get(i).getTexture().draw(x, y, 64, 64);
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
	
	public void drawDoors() {
		Map<Door, Optional<RoomDesign>> doors = level.getLevel().get(level.getRoomID()).getDoorAccess();
		
		for(Entry<Door, Optional<RoomDesign>> entry : doors.entrySet()) {
			if(entry.getValue().isPresent()) {
				if(entry.getKey().equals(Door.NORTH)) {
					level.getLevel().get(level.getRoomID()).getDoorHor().getTexture().getFlippedCopy(true, false).draw(GameSettings.WIDTH / 2 - GameSettings.TILESIZE, 0, GameSettings.TILESIZE, GameSettings.TILESIZE);
				} else if(entry.getKey().equals(Door.SOUTH)) {
					level.getLevel().get(level.getRoomID()).getDoorHor().getTexture().getFlippedCopy(true, true).draw(GameSettings.WIDTH / 2 - GameSettings.TILESIZE, GameSettings.HEIGHT - GameSettings.TILESIZE, GameSettings.TILESIZE, GameSettings.TILESIZE);
				} else if(entry.getKey().equals(Door.EAST)) {
					level.getLevel().get(level.getRoomID()).getDoorVert().getTexture().getFlippedCopy(true, false).draw(GameSettings.WIDTH - GameSettings.TILESIZE, GameSettings.HEIGHT / 2 - GameSettings.TILESIZE, GameSettings.TILESIZE, GameSettings.TILESIZE);
				} else {
					level.getLevel().get(level.getRoomID()).getDoorVert().getTexture().draw(0, GameSettings.HEIGHT / 2 - GameSettings.TILESIZE, GameSettings.TILESIZE, GameSettings.TILESIZE);
				}
			}
		}
	}
	
	
	public void drawDoorTop() throws SlickException {
		Map<Door, Optional<RoomDesign>> doors = level.getLevel().get(level.getRoomID()).getDoorAccess();
		Image image;
		
		for(Entry<Door, Optional<RoomDesign>> entry : doors.entrySet()) {
			if(entry.getValue().isPresent()) {
				if(entry.getKey().equals(Door.NORTH)) {
					image = new Image("./res/walls/doors/Door_top2.png");
					image.getFlippedCopy(true, false).draw(GameSettings.WIDTH / 2 - GameSettings.TILESIZE, 0, 64, 14);
				} else if(entry.getKey().equals(Door.SOUTH)) {
					image = new Image("./res/walls/doors/Door_top2.png");
					image.getFlippedCopy(true, true).draw(GameSettings.WIDTH / 2 - GameSettings.TILESIZE, GameSettings.HEIGHT - 14, 64, 14);
				} else if(entry.getKey().equals(Door.EAST)) {
					image = new Image("./res/walls/doors/Door_top1.png");
					image.getFlippedCopy(true, false).draw(GameSettings.WIDTH - 14, GameSettings.HEIGHT / 2 - GameSettings.TILESIZE, 14, 64);
				} else {
					image = new Image("./res/walls/doors/Door_top1.png");
					image.getFlippedCopy(false, false).draw(0, GameSettings.HEIGHT / 2 - GameSettings.TILESIZE, 14, 64);
				}
			}
		}
	}
	
	
	
	
	
}
