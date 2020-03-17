package Test1;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class TestState extends StateBasedGame {

	private static final String GAMENAME = "Test";
//	private static final int MENU = 0;  // Not useful now
	private static final int LEVEL1 = 1;
	
	private final static int WIDTH = 1296;
	private final static int HEIGHT = 720;
//	private final static int TILESIZE = 48;  // Not useful now
	
	public TestState(String name) {
		super(name);
		//this.addState(new Menu(MENU));  // Not useful now
		this.addState(new TestPlay(LEVEL1));
		
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
		System.setProperty("java.library.path", "./lib/natives");
		
		//Set the path for Slick2D resources
		System.setProperty("org.lwjgl.librarypath", new File("./lib/natives").getAbsolutePath());
		
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new TestState(GAMENAME));
			appgc.setDisplayMode(WIDTH, HEIGHT, false);
			appgc.setShowFPS(false);
			appgc.start();
		} catch (SlickException e) {
			Logger.getLogger(TestPlay.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
