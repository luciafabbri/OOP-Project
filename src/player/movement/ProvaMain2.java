package player.movement;

import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import bullet.player.BulletMovementImpl;
import gameEntities.Obstacle;
import genTest.Rendering;
import genTest.RenderingImpl;
import levels.Level;
import levels.LevelImpl;
import player.PlayerImpl;
import design.utilities.GameSettings;
import design.utilities.Pair;

	public class ProvaMain2 extends BasicGameState implements GameSettings{
		
		private Rendering graphics;
		private Level level;
		private Input input;
		private PlayerImpl playerDEF;
		private BulletMovementImpl bullet;
		private Obstacle obst;
		private Pair<Integer, Integer> position = new Pair<>(TILESIZE*3,TILESIZE*3);
		
		public ProvaMain2(final int state) {
			super();
		}

		@Override
		public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
			//Teoricamente qui si carica il livello in s� (il primo livello in questo caso)
			//per poi aggiornare la logica in update e la grafica in render
			try { 
				level = new LevelImpl(1);
			} catch (IOException e) {     //LUCI SONO FEDE HO MODIFICATO LevelImpl, PER TE NON CAMBIA NULLA
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    playerDEF=  new PlayerImpl(1, new Image("./res/chars/mainChar5_back.png"));
			graphics = new RenderingImpl(level);
			bullet = new BulletMovementImpl();
			obst = new Obstacle(position);
		}

		@Override
		public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
			graphics.drawFloor();
			graphics.drawWalls();
			graphics.drawItems();
			playerDEF.getImage().draw(playerDEF.getPosition().getX(),playerDEF.getPosition().getY(),64,64);
			arg2.clearClip();		
			
		}

		@Override
		public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
			input = arg0.getInput();
			playerDEF.setPosition(input);
			bullet.checkShooting(input);
			System.out.println(obst);
		}
		
		public int getID() {
			return 1;
		}
	}
