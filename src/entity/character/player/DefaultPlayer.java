package entity.character.player;

import design.utilities.Pair;
import entity.UpDownLeftRight;
import entity.move.Direction;

/**
 * Interface used to set several default values of the player   
 */

public interface DefaultPlayer {

	final static Pair<Integer,Integer> POSITION  = new Pair<>(64,64);
	
	final static Direction DIRECTION = Direction.EAST;
	
    final static int HEALTH = 100;
    
	public final static int DIMENSION = 64;
	
	public final static UpDownLeftRight<Integer> VERTICAL = new UpDownLeftRight<>(48, DIMENSION, 17, 46);
	
	public final static UpDownLeftRight<Integer> ORIZONTAL = new UpDownLeftRight<>(48, DIMENSION, 15, 48);

}
