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

import design.utilities.GameSettings;

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
	
	
	/**
	 *{@inheritDoc}
	 */
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		hoverButtonStart = false;
		hoverButtonEnd = false;
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
		
		
		arg2.setColor(Color.black);
		arg2.drawString("Start Game", (GameSettings.WIDTH / 2 - GameSettings.WIDTH / 8) + 70, (GameSettings.HEIGHT / 2) + 30);
		
		arg2.setColor(Color.black);
		arg2.drawString("Quit Game", (GameSettings.WIDTH / 2 - GameSettings.WIDTH / 8) + 70, (GameSettings.HEIGHT / 2) + 130);
		
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
		
	}

	
	/**
	 *Method that isn't used, must have because of inheritance
	 */
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
