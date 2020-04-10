package player.movement;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import design.utilities.GameSettings;


public class ProvaMain extends StateBasedGame implements GameSettings {

	private static final String GAMENAME = "Test";
//	private static final int MENU = 0;  // Not useful now
	private static final int LEVEL1 = 1;
	
	
	public ProvaMain(String name) {
		super(name);
		//this.addState(new Menu(MENU));  // Not useful now
		this.addState(new ProvaMain2(LEVEL1));
		
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		//this.getState(MENU).init(arg0, this);  // Not useful now
		this.getState(LEVEL1).init(arg0, this);
		this.enterState(LEVEL1); //FIRST SCREEN USER SEES
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
			appgc = new AppGameContainer(new ProvaMain(GAMENAME));
			appgc.setDisplayMode(WIDTH, HEIGHT, false);
			appgc.setShowFPS(false);
			appgc.start();
		} catch (SlickException e) {
			Logger.getLogger(ProvaMain2.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
