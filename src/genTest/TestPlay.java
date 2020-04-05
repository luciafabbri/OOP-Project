package genTest;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import items.ItemImpl;
import levels.Level;
import levels.Level1;
import utility.Pair;

public class TestPlay extends BasicGameState implements GameSettings{
	
	private Rendering graphics;
	private Level level;
	private Input input;
	
	public TestPlay(final int state) {
		super();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		//Teoricamente qui si carica il livello in s� (il primo livello in questo caso)
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
		input = arg0.getInput();
		ItemImpl tmp = level.getLevel().get(0).getItems().get(0);
		
		if((tmp.getCoord().getY() - 1 >= TILESIZE && tmp.getCoord().getX() - 1 >= TILESIZE) && input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_A)) {
			level.getLevel().get(0).getItems().get(0).setCoord(new Pair<>(tmp.getCoord().getX() - 1, tmp.getCoord().getY() - 1));
			
		} else if(tmp.getCoord().getY() - 1 >= TILESIZE && input.isKeyDown(Input.KEY_W)) {
			
			level.getLevel().get(0).getItems().get(0).setCoord(new Pair<>(tmp.getCoord().getX(), tmp.getCoord().getY() - 1));
		} else if(tmp.getCoord().getX() - 1 >= TILESIZE && input.isKeyDown(Input.KEY_A)){
			level.getLevel().get(0).getItems().get(0).setCoord(new Pair<>(tmp.getCoord().getX() - 1, tmp.getCoord().getY()));
		} else if(tmp.getCoord().getY() + 1 <= HEIGHT - TILESIZE * 2 && input.isKeyDown(Input.KEY_S)){
			level.getLevel().get(0).getItems().get(0).setCoord(new Pair<>(tmp.getCoord().getX(), tmp.getCoord().getY() + 1));
		} else if(tmp.getCoord().getX() + 1 <= WIDTH - TILESIZE * 2 && input.isKeyDown(Input.KEY_D)){
			level.getLevel().get(0).getItems().get(0).setCoord(new Pair<>(tmp.getCoord().getX() + 1, tmp.getCoord().getY()));
		}
	
	
	}
	
	public int getID() {
		return 1;
	}
}
