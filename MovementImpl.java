package player.movement;

import player.movement.Direction;
import utility.Pair;
import org.newdawn.slick.Input;

/**
 * Class that implements all the methods of Interface Movement
 * 
 * It allows the player to move in the environment: 
 * based on the command pressed, the player will be able to move in that direction
 * 
 */
public class MovementImpl implements Movement {
	
	private Direction direction;

	public MovementImpl() {
	}
		
	@Override
	public Pair<Integer, Integer> movePlayer(Input input, Pair<Integer,Integer> pos, Direction dir) {
		
		direction = dir;
		
		//control UP input   
		if( input.isKeyDown(Input.KEY_W) ) {
			this.direction = Direction.UP;
			return new Pair<Integer,Integer>(pos.getX(),pos.getY() - 1);
		}
		
		
		//control DOWN input   
		else if( input.isKeyDown(Input.KEY_S) ) {
			direction = Direction.DOWN;
			return new Pair<Integer,Integer>(pos.getX(),pos.getY() + 1);
		}

		
		//control LEFT input   
		else if( input.isKeyDown(Input.KEY_A) ) {
			this.direction = Direction.LEFT;
			return new Pair<Integer,Integer>(pos.getX() - 1,pos.getY());
		}

		
		//control RIGHT input   
		else if( input.isKeyDown(Input.KEY_D) ) {
			this.direction = Direction.RIGHT;
			return new Pair<Integer,Integer>(pos.getX() + 1,pos.getY());
		}
		
		
		//control UP-RIGHT input
		else if( input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_D) ) {
			this.direction = Direction.UPRIGHT;
			return new Pair<Integer,Integer>(pos.getX() + 1,pos.getY() - 1);
		}
		
		
		//control UP-LEFT input
		else if( input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_A) ) {
			direction = Direction.UPLEFT;
			return new Pair<Integer,Integer>(pos.getX() - 1,pos.getY() - 1);
		}
		
		
		//control DOWN-LEFT input
		else if( input.isKeyDown(Input.KEY_S) && input.isKeyDown(Input.KEY_A) ) {
			this.direction = Direction.DOWNLEFT;
			return new Pair<Integer,Integer>(pos.getX() - 1,pos.getY() + 1);
		}
		
		
		//control DOWN-RIGHT input 
		else if( input.isKeyDown(Input.KEY_S) && input.isKeyDown(Input.KEY_D) ) {
			this.direction = Direction.DOWNRIGHT;
			return new Pair<Integer,Integer>(pos.getX() + 1,pos.getY() + 1);
		}
		
		else throw new IllegalArgumentException();
		
	}

	
	@Override
	public Direction getDirection() {
		return this.direction;
	}
	
	
	@Override
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}