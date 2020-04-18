package player;

import design.utilities.Pair;
import utility.Direction;
import utility.UpDownLeftRight;


/**
 * 
 * Interface that set default values of the player  
 * 
 */

public interface DefaultPlayer {

	final static Pair<Integer,Integer> POSITION  = new Pair<>(64,64); // un tilesize è 64 
	final static Direction DIRECTION = Direction.EAST;
    final static int HEALTH = 100;
	public final static int DIMENSION = 64;
	public final static UpDownLeftRight VERTICAL = new UpDownLeftRight(48, DIMENSION, 17, 46);
	public final static UpDownLeftRight ORIZONTAL = new UpDownLeftRight(48, DIMENSION, 15, 48);

}
