package player;

import utility.Pair;
import utility.Direction;

public interface DefaultPlayer {

	final static Pair<Integer,Integer> POSITION  = new Pair<>(64,64); // un tilesize è 64 
	final static Direction DIRECTION = Direction.EAST;
    final static int HEALTH = 100;

}
