package coordination;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import dynamicBody.character.player.Player;
import dynamicBody.character.player.PlayerImpl;
import dynamicBody.move.Direction;
import worldModel.utilities.GameSettings;
import worldModel.utilities.Pair;

public class StateCoord extends StateBasedGame {

	/**
	 * Variable containing initializing of Player
	 */
	private static Player player;
	/**
	 * Variable containing the name of the Window
	 */
	private static final String GAMENAME = "JARG";
	/**
	 * Variable containing the ID for the Menu
	 */
	private static final int MENU = 0;  
	/**
	 * Variable containing the ID for the first level
	 */
	private static final int LEVEL1 = 1;
	
	/**
	 * Constructor for StateCoord
	 * @param name, which is the name of the Window
	 * @throws SlickException
	 * @see SlickException
	 */
	public StateCoord(String name) throws SlickException {
		super(name);
		StateCoord.player = new PlayerImpl(new Pair<>(GameSettings.TILESIZE, GameSettings.TILESIZE), Direction.SOUTH, 0);

		this.addState(new Menu());
		this.addState(new LevelsPlay(LEVEL1, player));		
	}

	/**
	 *{@inheritDoc}
	 */
	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
//		DO NOT REMOVE THESE COMMENTS, DOCUMENTATION SAYS THAT INITSTATES IS BROKEN
		
//		this.getState(MENU).init(arg0, this); 
//		this.getState(LEVEL1).init(arg0, this);
//		this.enterState(MENU); //FIRST SCREEN USER SEES
	}
	
	//QUI VA MAIN PER INIZIALIZZARE PRIMA IL MENU

	/**
	 * Main method for initializing the OpenGL context of the game, and the Player resource itself
	 * @param args
	 * @throws SlickException
	 * @see SlickException
	 */
	public static void main(String[] args) throws SlickException {
		//Set the path for Slick2D libraries
		System.setProperty("java.library.path", new File("./lib/libraries").getAbsolutePath());
		
		//Set the path for Slick2D natives
		System.setProperty("org.lwjgl.librarypath", new File("./lib/natives").getAbsolutePath());
		
		//Set the path for JInput
		System.setProperty("net.java.games.input.librarypath", new File("./lib/natives").getAbsolutePath());
		
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new StateCoord(GAMENAME));
			appgc.setDisplayMode(GameSettings.WIDTH, GameSettings.HEIGHT, false);
			appgc.setShowFPS(false);
			appgc.setVSync(true);
			appgc.setMaximumLogicUpdateInterval(80);
			appgc.start();
		} catch (SlickException e) {
			Logger.getLogger(LevelsPlay.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 * Method used by the enemies to get reference of Player
	 * @return Player
	 */
	public static Player getPlayer() {
		return player;
	}
}
