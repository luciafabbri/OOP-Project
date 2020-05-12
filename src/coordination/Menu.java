package coordination;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import worldModel.utilities.GameSettings;

public class Menu extends BasicGameState{

	/**
	 * Variable containing which input has been given from any controller
	 */
	private Input input;
	/**
	 * Variable containing the current X coordinates of the mouse cursor
	 */
	private int x;
	/**
	 * Variable containing the current Y coordinates of the mouse cursor
	 */
	private int y;
	/**
	 * Variable that is true if the mouse cursor is on the Start button, otherwise false
	 */
	private boolean hoverButtonStart;
	/**
	 * Variable that is true if the mouse cursor is on the End button, otherwise false
	 */
	private boolean hoverButtonEnd;
	/**
	 * Variable containing the data regarding the music to play upon clicking the Start button
	 */
	private Music music;
	private boolean hoverButtonTutorial;
	private boolean tutorialScreen;
	private boolean hoverButtonBack;
	
	/**
	 *{@inheritDoc}
	 */
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		hoverButtonStart = false;
		hoverButtonEnd = false;
		this.hoverButtonTutorial = false;
		this.tutorialScreen = false;
		this.hoverButtonBack = false;
		this.music = new Music("./res/audio/music/Ominous_Music.wav");
		
	}

	/**
	 *{@inheritDoc}
	 */
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		
		//Here I will render the main screen via buttons
		arg2.setColor(Color.black);
		arg2.drawRect(0, 0, GameSettings.WIDTH, GameSettings.HEIGHT);
		
		if(!tutorialScreen) {
			this.mainMenu(arg2);
		} else {
			this.tutorialMenu(arg2);
		}
		
	}
	
	private void tutorialMenu(final Graphics arg2) {
		arg2.setColor(Color.white);
		
		int width = GameSettings.TILESIZE;
		int height = (GameSettings.TILESIZE / 2) + 60;
		
		arg2.drawString("You are a Knight Archer, on your quest to defeat the evil Knight Darklord.", width, height);
		arg2.drawString("To play the game, use the WASD keys to move the Archer in the four cardinal directions (North, West, East and South).", width, height + 50);
		arg2.drawString("And to pause your adventure, press the Escape button.", width, height + 50 * 2);
		arg2.drawString("In each room you will found many objects:", width, height + 50 * 3);
		arg2.drawString("-Enemies, that will try to defeat you, use your bow and arrow via the Space key to annihilate them!", width, height + 50 * 4);
		arg2.drawString("-Keys, that you need to get in order to open the doors to the next room!", width, height + 50 * 5);
		arg2.drawString("-Upgrades, that your Hero can pick up in order to get Stronger, Faster and more Resilient to damage.", width, height + 50 * 6);
		arg2.drawString("-Coins, ancient relics stolen by the Darklord from your family Crypt.", width, height + 50 * 7);
		arg2.drawString("Now you have everything you need to know to defeat Evil and bring peace to your family, Good Luck!.", width, height + 50 * 8);
	
		if(hoverButtonBack) {
			arg2.setColor(Color.gray);
		} else {
			arg2.setColor(Color.white);
		}
		arg2.fillRect(width, height + 50 * 10, 240, 40);
		
		arg2.setColor(Color.black);
		arg2.drawString("Back", width + 100, (height + 50 * 10) + 10);
	}

	private void mainMenu(final Graphics arg2) {
		if(hoverButtonStart) {
			arg2.setColor(Color.gray);
		} else {
			arg2.setColor(Color.white);
		}
		arg2.fillRect(GameSettings.WIDTH / 2 - GameSettings.WIDTH / 8, GameSettings.HEIGHT / 2 + 20, 240, 40);
		
		if(hoverButtonEnd) {
			arg2.setColor(Color.gray);
		} else {
			arg2.setColor(Color.white);
		}
		arg2.fillRect(GameSettings.WIDTH / 2 - GameSettings.WIDTH / 8, GameSettings.HEIGHT / 2 + 120, 240, 40);
		
		if(hoverButtonTutorial) {
			arg2.setColor(Color.gray);
		} else {
			arg2.setColor(Color.white);
		}
		arg2.fillRect(GameSettings.WIDTH / 2 - GameSettings.WIDTH / 8, GameSettings.HEIGHT / 2 + 220, 240, 40);
		
		arg2.setColor(Color.black);
		arg2.drawString("Start Game", (GameSettings.WIDTH / 2 - GameSettings.WIDTH / 8) + 70, (GameSettings.HEIGHT / 2) + 30);
		
		arg2.setColor(Color.black);
		arg2.drawString("Quit Game", (GameSettings.WIDTH / 2 - GameSettings.WIDTH / 8) + 70, (GameSettings.HEIGHT / 2) + 130);
		
		arg2.setColor(Color.black);
		arg2.drawString("How to Play", (GameSettings.WIDTH / 2 - GameSettings.WIDTH / 8) + 70, (GameSettings.HEIGHT / 2) + 230);
		
		arg2.scale(2, 2);
		
		arg2.setColor(Color.white);
		arg2.drawString("JARG", GameSettings.WIDTH / 4 - 40, 60);
		arg2.drawString("Just Another RogueLike Game", GameSettings.WIDTH / 4 - 130, 100);
	}
	
	
	/**
	 *{@inheritDoc}
	 */
	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		input = arg0.getInput();
		x = Mouse.getX();
		y = Mouse.getY();
		
		
		if(!tutorialScreen) {
			this.mainMenuUpdate(arg0, arg1);
		} else {
			this.tutorialMenuUpdate();
		}
		
		
	}
	
	private void mainMenuUpdate(final GameContainer arg0, final StateBasedGame arg1) {
		if((x > (GameSettings.WIDTH / 2 - GameSettings.WIDTH / 8) && x < (GameSettings.WIDTH / 2 - GameSettings.WIDTH / 8 + 240)) &&
		   (y < ((GameSettings.HEIGHT / 2) - 20) && y > ((GameSettings.HEIGHT / 2) - 60))) {
			hoverButtonStart = true;
			if(input.isMousePressed(0)) {
				music.loop(1.0f, 0.04f);
				arg1.enterState(1);
			}
		} else {
			hoverButtonStart = false;
		}
				
		if((x > (GameSettings.WIDTH / 2 - GameSettings.WIDTH / 8) && x < (GameSettings.WIDTH / 2 - GameSettings.WIDTH / 8 + 240)) &&
		   (y < (GameSettings.HEIGHT / 2 - 120) && y > (GameSettings.HEIGHT / 2 - 160))) {
			hoverButtonEnd = true;
			if(input.isMousePressed(0)) {
				arg0.exit();
			}
		} else {
			hoverButtonEnd = false;
		}
				
		if((x > (GameSettings.WIDTH / 2 - GameSettings.WIDTH / 8) && x < (GameSettings.WIDTH / 2 - GameSettings.WIDTH / 8 + 240)) &&
		   (y < (GameSettings.HEIGHT / 2 - 220) && y > (GameSettings.HEIGHT / 2 - 260))) {
			hoverButtonTutorial = true;
			if(input.isMousePressed(0)) {
				tutorialScreen = true;
			}
		} else {
			hoverButtonTutorial = false;
		}
	}
	
	private void tutorialMenuUpdate() {
		int width = GameSettings.TILESIZE;
		int height = (GameSettings.TILESIZE / 2) + 60;
		
		if((x > width && x < width + 240) &&
		   ((y < (height + 45) + 40 && y > height + 45))) {
			hoverButtonBack = true;
			if(input.isMousePressed(0)) {
				tutorialScreen = false;
			}
		} else {
			hoverButtonBack = false;
		}
	}
	
	
	/**
	 *Method that isn't used, must have because of inheritance
	 */
	@Override
	public int getID() {
		return 0;
	}

}
