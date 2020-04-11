package coordination;
import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import gameEntities.items.ItemImpl;
import levels.Level;
import levels.LevelImpl;

public class TestPlay extends BasicGameState {
	
	private Rendering graphics;
	private LogicImpl logic;
	private Level level;
	private Input input;
	private int levelID;
	
	public TestPlay(final int state) {
		super();
		this.levelID = state;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		//Teoricamente qui si carica il livello in s� (il primo livello in questo caso)
		//per poi aggiornare la logica in update e la grafica in render
		try {
			level = new LevelImpl(this.levelID);
			logic = new LogicImpl(level);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		logic.switchRooms(input);
		
		
		
		
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
	
	public int getID() {
		return levelID;
	}
}
