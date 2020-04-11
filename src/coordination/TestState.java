package coordination;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import design.utilities.GameSettings;


public class TestState extends StateBasedGame {

	private static final String GAMENAME = "JARG";
	private static final int MENU = 0;  
	private static final int LEVEL1 = 1;
	
	
	public TestState(String name) {
		super(name);
		this.addState(new Menu());
		this.addState(new TestPlay(LEVEL1));
		
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		this.getState(MENU).init(arg0, this); 
		this.getState(LEVEL1).init(arg0, this);
		this.enterState(MENU); //FIRST SCREEN USER SEES
	}
	
	//QUI VA MAIN PER INIZIALIZZARE PRIMA IL MENU

	public static void main(String[] args) {
		//Set the path for Slick2D libraries
		System.setProperty("java.library.path", new File("./lib/libraries").getAbsolutePath());
		
		//Set the path for Slick2D natives
		System.setProperty("org.lwjgl.librarypath", new File("./lib/natives").getAbsolutePath());
		
		//Set the path for JInput
		System.setProperty("net.java.games.input.librarypath", new File("./lib/natives").getAbsolutePath());
		
		
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new TestState(GAMENAME));
			appgc.setDisplayMode(GameSettings.WIDTH, GameSettings.HEIGHT, false);
			appgc.setShowFPS(false);
			appgc.start();
		} catch (SlickException e) {
			Logger.getLogger(TestPlay.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
