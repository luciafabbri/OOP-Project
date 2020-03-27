package genTest;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import levels.Level;
import levels.Level1;

public class TestPlay extends BasicGameState{
	
	private Rendering graphics;
	private Level level;
	
	public TestPlay(final int state) {
		super();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		//Teoricamente qui si carica il livello in sè (il primo livello in questo caso)
		//per poi aggiornare la logica in update e la grafica in render
		level = new Level1();
		
		graphics = new RenderingImpl(level);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		graphics.drawFloor();
		graphics.drawWalls();
		graphics.drawItems();
		
		arg2.clearClip();
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		
	}
	
	public int getID() {
		return 1;
	}
}
