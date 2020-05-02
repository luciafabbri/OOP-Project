package dynamicBody.character.player.movement;

import design.utilities.Pair;
import dynamicBody.move.Direction;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * Class that implements interface Movement used to move the player through the different rooms in the dungeon 
 */

public class MovementImpl implements Movement {
	
	private Direction direction;
	private int newSpeed;
	private Sound footsteps;
	
	/**
	 * Default constructor
	 */
	public MovementImpl() {
		try {
			footsteps = new Sound("./res/audio/footsteps/footsteps.wav");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Override
	public Pair<Integer, Integer> movePlayer(Input input, Pair<Integer,Integer> pos, Direction dir, int speed) {
		direction = dir;
		newSpeed = speed;
			
		//control UP input   
		if( input.isKeyDown(Input.KEY_W) ) {
			this.direction = Direction.NORTH;
			if(!footsteps.playing())
				footsteps.play(1.0f, 0.5f);
			return new Pair<Integer,Integer>(pos.getX(),pos.getY() - newSpeed);
		}
		
		
		//control DOWN input   
		if( input.isKeyDown(Input.KEY_S) ) {
			this.direction = Direction.SOUTH;
			if(!footsteps.playing())
				footsteps.play(1.0f, 0.5f);
			return new Pair<Integer,Integer>(pos.getX(),pos.getY() + newSpeed);
		}

		
		//control LEFT input   
		if( input.isKeyDown(Input.KEY_A) ) {
			this.direction = Direction.WEST;
			if(!footsteps.playing())
				footsteps.play(1.0f, 0.5f);
			return new Pair<Integer,Integer>(pos.getX() - newSpeed,pos.getY());
		}

		
		//control RIGHT input   
		if( input.isKeyDown(Input.KEY_D) ) {
			this.direction = Direction.EAST;
			if(!footsteps.playing())
				footsteps.play(1.0f, 0.5f);
			return new Pair<Integer,Integer>(pos.getX() + newSpeed,pos.getY());
		}
		
		return pos;
	}

	@Override
	public Direction getDirection() {
		return this.direction;
	}

}