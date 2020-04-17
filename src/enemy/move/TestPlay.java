package enemy.move;

import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import coordination.LogicImpl;
import coordination.Rendering;
import coordination.RenderingImpl;
import design.utilities.GameSettings;
import design.utilities.Pair;
import enemy.Monster;
import enemy.TypeAttack;
import enemy.TypeMove;
import levels.Level;
import levels.LevelImpl;
import player.Player;
import player.PlayerImpl;
import utility.Direction;

public class TestPlay extends BasicGameState {

	private Player player;
	private Rendering graphics;
	private LogicImpl logic;
	private Level level;
	private Input input;
	private int levelID;
	private Monster tmp;

	public TestPlay(final int state) {
		super();
		this.levelID = state;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// Teoricamente qui si carica il livello in s� (il primo livello in questo
		// caso)
		// per poi aggiornare la logica in update e la grafica in render
		try {
			level = new LevelImpl(this.levelID);
			tmp = new Monster(new Pair<Integer, Integer>(GameSettings.TILESIZE * 2, GameSettings.TILESIZE * 2),
					"ciaoTest", 100, TypeMove.TELEPORT, Direction.NORTH_EAST, TypeAttack.ONE_SIDE,
					level.getLevel().get(0).getRoom());
			player = new PlayerImpl(new Pair<>(GameSettings.TILESIZE, GameSettings.TILESIZE), Direction.SOUTH, 0,
					new Image("./res/chars/mainChar6_front.png"), level.getLevel().get(level.getRoomID()).getRoom());
			logic = new LogicImpl(level, player, tmp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		graphics = new RenderingImpl(level, player, tmp);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		graphics.drawFloor();
		graphics.drawWalls();
		graphics.drawItems();
		graphics.drawDoors();
		graphics.drawObstacles();
		graphics.drawMain();
		graphics.drawDoorTop();

		arg2.drawString("X: " + player.getPosition().getX() + " | Y: " + player.getPosition().getY(), 0, 0);

		arg2.clearClip();

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		input = arg0.getInput();

		logic.moveMain(input);
		logic.switchRooms(input);

		logic.getMonster().updatePos();

		/*
		 * ItemImpl tmp = level.getLevel().get(0).getItems().get(0);
		 * 
		 * if((tmp.getCoord().getY() - 1 >= GameSettings.TILESIZE &&
		 * tmp.getCoord().getX() - 1 >= GameSettings.TILESIZE) &&
		 * input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_A)) {
		 * level.getLevel().get(0).getItems().get(0).setCoord(new
		 * Pair<>(tmp.getCoord().getX() - 1, tmp.getCoord().getY() - 1));
		 * 
		 * } else if(tmp.getCoord().getY() - 1 >= GameSettings.TILESIZE - 70 &&
		 * input.isKeyDown(Input.KEY_W)) {
		 * level.getLevel().get(0).getItems().get(0).setCoord(new
		 * Pair<>(tmp.getCoord().getX(), tmp.getCoord().getY() - 1)); } else
		 * if(tmp.getCoord().getX() - 1 >= GameSettings.TILESIZE &&
		 * input.isKeyDown(Input.KEY_A)){
		 * level.getLevel().get(0).getItems().get(0).setCoord(new
		 * Pair<>(tmp.getCoord().getX() - 1, tmp.getCoord().getY())); } else
		 * if(tmp.getCoord().getY() + 1 <= GameSettings.HEIGHT - GameSettings.TILESIZE *
		 * 2 && input.isKeyDown(Input.KEY_S)){
		 * level.getLevel().get(0).getItems().get(0).setCoord(new
		 * Pair<>(tmp.getCoord().getX(), tmp.getCoord().getY() + 1)); } else
		 * if(tmp.getCoord().getX() + 1 <= GameSettings.WIDTH - GameSettings.TILESIZE *
		 * 2 && input.isKeyDown(Input.KEY_D)){
		 * level.getLevel().get(0).getItems().get(0).setCoord(new
		 * Pair<>(tmp.getCoord().getX() + 1, tmp.getCoord().getY())); }
		 * 
		 */

	}

	public int getID() {
		return levelID;
	}
}
