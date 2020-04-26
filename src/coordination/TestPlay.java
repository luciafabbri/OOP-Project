package coordination;
import java.io.IOException;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import design.utilities.GameSettings;
import levels.Level;
import levels.LevelImpl;
import player.Player;

public class TestPlay extends BasicGameState {
	
	private Color color;
	
	private Player player;
	private Rendering graphics;
	private LogicImpl logic;
	private UI ui;
	private Level level;
	private Input input;
	private int levelID;
	
	public TestPlay(final int state, final Player player) {
		super();
		this.levelID = state;
		this.player = player;
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		
		player.loadAnimations();
		
		try {
			level = new LevelImpl(this.levelID);
			logic = new LogicImpl(level, player);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player.setCurrentRoom(level.getLevel().get(0).getRoom());
		
		graphics = new RenderingImpl(level, player);
	
		ui = new UI(player, arg0.getGraphics());
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		input = arg0.getInput();
		
		graphics.drawFloor();
		graphics.drawWalls();
		graphics.drawItems();
		graphics.drawDoors();
		graphics.drawObstacles();
		graphics.drawMain(input);
		graphics.drawDoorTop();
		graphics.drawMod();
		graphics.drawMainProj();
		graphics.drawEnemies();
		ui.drawUI();
		
		
		
		
		arg2.drawString("X: " + player.getPosition().getX() + " | Y: " +player.getPosition().getY(), GameSettings.WIDTH - GameSettings.TILESIZE * 5, 0);
		arg2.drawString("Level: " + this.getID() + " | Room: " +level.getRoomID(), GameSettings.WIDTH - GameSettings.TILESIZE * 5, 16);
		arg2.drawString("Stairs: " + level.getLevel().get(level.getRoomID()).getRoom().areStairsPresent(), GameSettings.WIDTH - GameSettings.TILESIZE * 5, 32);

		arg2.clearClip();
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		input = arg0.getInput();
		
		logic.moveMain(input);
		logic.switchRooms(input);
		logic.shootMain(input);
		logic.moveMainProj(input);
		logic.eliminateMainProj();
		logic.moveEnemies();
		
		if(player.getCheck().checkStairs(level.getLevel().get(level.getRoomID()).getRoom(), player.getPosition())) {
			this.levelID++;
			init(arg0, arg1);
		}
			
		
		
		/*
		ItemImpl tmp = level.getLevel().get(0).getItems().get(0);
		
		if((tmp.getCoord().getY() - 1 >= GameSettings.TILESIZE && tmp.getCoord().getX() - 1 >= GameSettings.TILESIZE) && input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_A)) {
			level.getLevel().get(0).getItems().get(0).setCoord(new Pair<>(tmp.getCoord().getX() - 1, tmp.getCoord().getY() - 1));
			
		} else if(tmp.getCoord().getY() - 1 >= GameSettings.TILESIZE - 70 && input.isKeyDown(Input.KEY_W)) {
			level.getLevel().get(0).getItems().get(0).setCoord(new Pair<>(tmp.getCoord().getX(), tmp.getCoord().getY() - 1));
		} else if(tmp.getCoord().getX() - 1 >= GameSettings.TILESIZE && input.isKeyDown(Input.KEY_A)){
			level.getLevel().get(0).getItems().get(0).setCoord(new Pair<>(tmp.getCoord().getX() - 1, tmp.getCoord().getY()));
		} else if(tmp.getCoord().getY() + 1 <= GameSettings.HEIGHT - GameSettings.TILESIZE * 2 && input.isKeyDown(Input.KEY_S)){
			level.getLevel().get(0).getItems().get(0).setCoord(new Pair<>(tmp.getCoord().getX(), tmp.getCoord().getY() + 1));
		} else if(tmp.getCoord().getX() + 1 <= GameSettings.WIDTH - GameSettings.TILESIZE * 2 && input.isKeyDown(Input.KEY_D)){
			level.getLevel().get(0).getItems().get(0).setCoord(new Pair<>(tmp.getCoord().getX() + 1, tmp.getCoord().getY()));
		}
	
		*/
	}
	
	public int getID() {
		return levelID;
	}
}
