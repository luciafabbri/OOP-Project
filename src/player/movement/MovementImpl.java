package player.movement;

import design.utilities.Pair;
import utility.Direction;
import org.newdawn.slick.Input;

/**
 * 
 * Class that implements all the methods of Interface Movement
 * 
 */
public class MovementImpl implements Movement {
	
	private Direction direction;
	private int speed = 1;
	
	public MovementImpl() {
	}
		
	@Override
	public Pair<Integer, Integer> movePlayer(Input input, Pair<Integer,Integer> pos, Direction dir) {
		
		direction = dir;
		
/**		//control UP-RIGHT input
		if( input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_D) ) {
			this.direction = Direction.NORTH_EAST;
			return new Pair<Integer,Integer>(pos.getX() + speed,pos.getY() - speed);
		}
		
		
		//control UP-LEFT input
		if( input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_A) ) {
			direction = Direction.NORTH_WEST;
			return new Pair<Integer,Integer>(pos.getX() - speed,pos.getY() - speed);
		}
		
		
		//control DOWN-LEFT input
		if( input.isKeyDown(Input.KEY_S) && input.isKeyDown(Input.KEY_A) ) {
			this.direction = Direction.SOUTH_WEST;
			return new Pair<Integer,Integer>(pos.getX() - speed,pos.getY() + speed);
		}
		
		
		//control DOWN-RIGHT input 
		if( input.isKeyDown(Input.KEY_S) && input.isKeyDown(Input.KEY_D) ) {
			this.direction = Direction.SOUTH_EAST;
			return new Pair<Integer,Integer>(pos.getX() + speed,pos.getY() + speed);
		}
		
*/		
		//control UP input   
		if( input.isKeyDown(Input.KEY_W) ) {
			this.direction = Direction.NORTH;
			return new Pair<Integer,Integer>(pos.getX(),pos.getY() - speed);
		}
		
		
		//control DOWN input   
		else if( input.isKeyDown(Input.KEY_S) ) {
			this.direction = Direction.SOUTH;
			return new Pair<Integer,Integer>(pos.getX(),pos.getY() + speed);
		}

		
		//control LEFT input   
		else if( input.isKeyDown(Input.KEY_A) ) {
			this.direction = Direction.WEST;
			return new Pair<Integer,Integer>(pos.getX() - speed,pos.getY());
		}

		
		//control RIGHT input   
		else if( input.isKeyDown(Input.KEY_D) ) {
			this.direction = Direction.EAST;
			return new Pair<Integer,Integer>(pos.getX() + speed,pos.getY());
		}
		
		return pos;
	}

	
	@Override
	public Direction getDirection() {
		return this.direction;
	}

}