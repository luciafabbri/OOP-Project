package coordination;
import java.io.IOException;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import dynamicBody.character.player.Player;
import levels.Level;
import levels.LevelImpl;
import worldModel.utilities.GameSettings;
import worldModel.utilities.Pair;

public class GameController extends BasicGameState {
	
	/**
	 * Variable that contains the data of the Player
	 */
	private Player player;
	/**
	 * Variable containing the Graphics class
	 */
	private GameView graphics;
	/**
	 * Variable containing the Logic class
	 */
	private ModelCommunicator logic;
	/**
	 * Variable containing the UI class
	 */
	private UI ui;
	/**
	 * Variable containing the Level class
	 */
	private Level level;
	/**
	 * Variable containing which input is received from every computer controller
	 */
	private Input input;
	/**
	 * Variable containing the current level being displayed
	 */
	private int levelID;
	
	/**
	 * Constructor to build initial level
	 * @param state, indicates which level to load first
	 * @param player, indicates the Player environment to keep track of
	 * @throws SlickException
	 * @see SlickException
	 */
	public GameController(final int state, final Player player) throws SlickException {
		super();
		this.levelID = state;
		this.player = player;
	}
	
	/**
	 *{@inheritDoc} 
	 */
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		
		try {
			level = new LevelImpl(this.levelID);
			this.player.loadAnimations();
			
			logic = new ModelCommunicatorImpl(level, player);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player.setCurrentRoom(level.getLevel().get(0).getRoom());
		player.transitionPos(new Pair<>(GameSettings.WIDTH / 2 - GameSettings.TILESIZE, GameSettings.TILESIZE));
		
		graphics = new GameViewImpl(level, player);
	
		ui = new UI(player, arg0.getGraphics(), level);
	}

	/**
	 *{@inheritDoc}
	 */
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		input = arg0.getInput();
		
		graphics.drawFloor();
		graphics.drawWalls();
		
		graphics.drawItems();
		graphics.drawMod();
		graphics.drawObstacles();
		
		graphics.drawDoors();
		
		graphics.drawEnemies();
		
		graphics.drawMain(input);
		
		graphics.drawDoorTop();
		
		ui.drawUI();
		
		
		arg2.drawString("X: " + player.getPosition().getX() + " | Y: " +player.getPosition().getY(), GameSettings.WIDTH - GameSettings.TILESIZE * 5, 0);
		arg2.drawString("Level: " + this.getID() + " | Room: " +level.getRoomID(), GameSettings.WIDTH - GameSettings.TILESIZE * 5, 16);
		arg2.drawString("Stairs: " + level.getLevel().get(level.getRoomID()).getRoom().areStairsPresent(), GameSettings.WIDTH - GameSettings.TILESIZE * 5, 32);

		arg2.clearClip();
	}

	/**
	 *{@inheritDoc}
	 */
	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		input = arg0.getInput();
		
		logic.setRoomCleared();
		
		if(!level.isPauseMenu()) {
			logic.moveMain(input);
			logic.shootMain(input);
			
			logic.moveEnemies();
			logic.shootEnemies();
			
			logic.switchRooms(input);
		}
		
		logic.pauseMenu(input);
		
		if(player.getCheck().checkStairs(level.getLevel().get(level.getRoomID()).getRoom(), player.getPosition())) {
			this.levelID++;
			this.init(arg0, arg1);
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
	
	/**
	 * Method that returns current level
	 * @return int, that indicates which current level is loaded
	 */
	public int getID() {
		return levelID;
	}
}
