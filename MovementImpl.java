package player.movement;

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
	
	public MovementImpl() {
	}
		
	@Override
	public Pair<Integer, Integer> movePlayer(Input input, Pair<Integer,Integer> pos) {
		
		//control UP input   
		if( input.isKeyDown(Input.KEY_W) ) {
			return new Pair<Integer,Integer>(pos.getX(),pos.getY() - 1);
		}
		
		
		//control DOWN input   
		else if( input.isKeyDown(Input.KEY_S) ) {
			return new Pair<Integer,Integer>(pos.getX(),pos.getY() + 1);
		}

		
		//control LEFT input   
		else if( input.isKeyDown(Input.KEY_A) ) {
			return new Pair<Integer,Integer>(pos.getX() - 1,pos.getY());
		}

		
		//control RIGHT input   
		else if( input.isKeyDown(Input.KEY_D) ) {
			return new Pair<Integer,Integer>(pos.getX() + 1,pos.getY());
		}
		
		
		//control UP-RIGHT input
		else if( input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_D) ) {
			return new Pair<Integer,Integer>(pos.getX() + 1,pos.getY() - 1);
		}
		
		
		//control UP-LEFT input
		else if( input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_A) ) {
			return new Pair<Integer,Integer>(pos.getX() - 1,pos.getY() - 1);
		}
		
		
		//control DOWN-LEFT input
		else if( input.isKeyDown(Input.KEY_S) && input.isKeyDown(Input.KEY_A) ) {
			return new Pair<Integer,Integer>(pos.getX() - 1,pos.getY() + 1);
		}
		
		
		//control DOWN-RIGHT input 
		else if( input.isKeyDown(Input.KEY_S) && input.isKeyDown(Input.KEY_D) ) {
			return new Pair<Integer,Integer>(pos.getX() + 1,pos.getY() + 1);
		}
		
		else throw new IllegalArgumentException();
		
	}

}