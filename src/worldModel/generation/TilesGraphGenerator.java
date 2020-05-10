package worldModel.generation;

import worldModel.RoomModel;
import worldModel.utilities.Pair;
import worldModel.utilities.graphs.*;

/**
 * Interface that defines methods to map a room's layout into a Graph
 *
 */
public interface TilesGraphGenerator {

	/**
	 * @param RoomModel object room
	 * @return a Bidirectional Graph where the edges are the room's tiles and the
	 *         edges are the connections between tiles
	 */
	BidirectionalGraph<Pair<Integer, Integer>> generateTilesGraph(RoomModel room);

}
