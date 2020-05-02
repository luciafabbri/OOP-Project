package design.generation;

import design.RoomDesign;
import design.utilities.Pair;
import design.utilities.graphs.*;

/**
 * Interface that defines methods to map a room's layout into a Graph
 *
 */
public interface TilesGraphGenerator {

	/**
	 * @param RoomDesign object room
	 * @return a Bidirectional Graph where the edges are the room's tiles and the
	 *         edges are the connections between tiles
	 */
	BidirectionalGraph<Pair<Integer, Integer>> generateTilesGraph(RoomDesign room);

}
