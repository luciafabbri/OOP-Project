package dynamicBody.character.player;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import coordination.LogicImpl;
import design.utilities.Pair;
import dynamicBody.bullet.Bullet;
import dynamicBody.bullet.BulletPlayerImpl;
import dynamicBody.move.Direction;
import levels.Level;

/**
 * Class used to create a test for input using Slick2D library
 */

public class TestPlayerInput extends BasicGame {
	
	private AppGameContainer app;
	private Input input;
	
	private static Player testPlayer;
	private static Bullet testBullet; 
		
	/** Input variables to check, true if pressed */
	private boolean space;
	private boolean inputA;
	private boolean inputW;
	private boolean inputD;
	private boolean inputS;
	
	private boolean dirA;
	private boolean dirW;
	private boolean dirD;
	private boolean dirS;
	
	/**
	 * Default constructor of this test class
	 */
	public TestPlayerInput() {
		super(" INPUT TEST ");
	}
	
	/**
	 * @see org.newdawn.slick.BasicGame#init(org.newdawn.slick.GameContainer)
	 */
	public void init(GameContainer container) throws SlickException {
		if (container instanceof AppGameContainer) {
			app = (AppGameContainer) container;
		}
		input = container.getInput();
		testPlayer = new PlayerImpl(new Pair<>(128, 128), Direction.SOUTH, 0);
		testBullet = new BulletPlayerImpl(testPlayer.getPosition(), testPlayer.getDamage(), testPlayer.getDirection(), testPlayer.getRoom());
	}

	/**
	 * @see org.newdawn.slick.BasicGame#render(org.newdawn.slick.GameContainer, org.newdawn.slick.Graphics)
	 */
	public void render(GameContainer container, Graphics g) {
		g.drawString("Posizione iniziale del player: " + testPlayer.getPosition() + " Direzione: " +testPlayer.getDirection(), 10, 30);
		g.drawString("Posizione iniziale del proiettile: " +testBullet.getPos() + " Direzione: " +testBullet.getDirection(), 10, 50);

		g.drawString("Il player sta sparando: "+ space, 10, 100); 

        g.drawString("KEY UP (W): "+ inputW, 10, 150); 
        g.drawString("NORTH: "+ dirW, 10, 170);
        
        g.drawString("KEY DOWN (S): "+ inputS, 10, 210); 
        g.drawString("SOUTH: "+ dirS, 10, 230); 
        
        g.drawString("KEY LEFT (A): "+ inputA, 10, 270); 
        g.drawString("WEST: "+ dirA, 10, 290); 
        
        g.drawString("KEY RIGHT (D): "+ inputD, 10, 330); 
        g.drawString("EAST: "+ dirD, 10, 350); 
        
	}

	/**
	 * @throws SlickException 
	 * @see org.newdawn.slick.BasicGame#update(org.newdawn.slick.GameContainer, int)
	 */
	public void update(GameContainer container, int delta) throws SlickException {
		space = container.getInput().isKeyDown(Input.KEY_SPACE); 
		
		inputA = container.getInput().isKeyDown(Input.KEY_A);
        inputW = container.getInput().isKeyDown(Input.KEY_W);
        inputD = container.getInput().isKeyDown(Input.KEY_D);
        inputS = container.getInput().isKeyDown(Input.KEY_S);
        
		dirA = container.getInput().isKeyDown(Input.KEY_A);
		dirW = container.getInput().isKeyDown(Input.KEY_W);
		dirD = container.getInput().isKeyDown(Input.KEY_D);
		dirS = container.getInput().isKeyDown(Input.KEY_S);
	
  	    if(inputA) {
  			testPlayer.getMove().setDirection(Direction.NORTH);
  		}
    	if(inputW) {
  			testPlayer.getMove().setDirection(Direction.SOUTH);
  		}
  		if(inputD) {
  			testPlayer.getMove().setDirection(Direction.WEST);
  		}
  		if(inputS) {
  			testPlayer.getMove().setDirection(Direction.EAST);
  		} 
	
	}

	/**
	 * @see org.newdawn.slick.BasicGame#keyPressed(int, char)
	 */
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_ESCAPE) {
			System.exit(0);
		}
	}
	
	/**
	 * This is the entry point to the test
	 * @param argv, arguments passed into the test
 	 */
	public static void main(String[] argv) {
		try {
			AppGameContainer container = new AppGameContainer(new TestPlayerInput());
			container.setDisplayMode(800,600,false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
