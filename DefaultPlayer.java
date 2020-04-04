package player;

import utility.Pair;
import player.movement.*;

public interface DefaultPlayer {

	final static Pair<Integer,Integer> POSITION  = new Pair<>(64,64); // un tilesize è 64 
	final static Direction DIRECTION = Direction.RIGHT ;
	final static int HEALTH = 100;
}
