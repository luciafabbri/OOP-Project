package player.movement;

import utility.Pair;
import utility.Direction;
import org.newdawn.slick.Input;

/**
 * 
 * Class that implements all the methods of Interface Movement
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
			this.direction = Direction.NORD;
			return new Pair<Integer,Integer>(pos.getX(),pos.getY() - 1);
		}
		
		
		//control DOWN input   
		else if( input.isKeyDown(Input.KEY_S) ) {
			this.direction = Direction.SOUTH;
			return new Pair<Integer,Integer>(pos.getX(),pos.getY() + 1);
		}

		
		//control LEFT input   
		else if( input.isKeyDown(Input.KEY_A) ) {
			this.direction = Direction.WEST;
			return new Pair<Integer,Integer>(pos.getX() - 1,pos.getY());
		}

		
		//control RIGHT input   
		else if( input.isKeyDown(Input.KEY_D) ) {
			this.direction = Direction.EAST;
			return new Pair<Integer,Integer>(pos.getX() + 1,pos.getY());
		}
		
		
		//control UP-RIGHT input
		else if( input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_D) ) {
			this.direction = Direction.NORD_EAST;
			return new Pair<Integer,Integer>(pos.getX() + 1,pos.getY() - 1);
		}
		
		
		//control UP-LEFT input
		else if( input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_A) ) {
			direction = Direction.NORD_WEST;
			return new Pair<Integer,Integer>(pos.getX() - 1,pos.getY() - 1);
		}
		
		
		//control DOWN-LEFT input
		else if( input.isKeyDown(Input.KEY_S) && input.isKeyDown(Input.KEY_A) ) {
			this.direction = Direction.SOUTH_WEST;
			return new Pair<Integer,Integer>(pos.getX() - 1,pos.getY() + 1);
		}
		
		
		//control DOWN-RIGHT input 
		else if( input.isKeyDown(Input.KEY_S) && input.isKeyDown(Input.KEY_D) ) {
			this.direction = Direction.SOUTH_EAST;
			return new Pair<Integer,Integer>(pos.getX() + 1,pos.getY() + 1);
		}
		
		return pos;
	}

	
	@Override
	public Direction getDirection() {
		return this.direction;
	}

}