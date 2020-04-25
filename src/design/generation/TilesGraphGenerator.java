package design.generation;

import design.RoomDesign;
import design.utilities.Pair;
import design.utilities.graphs.*;

public interface TilesGraphGenerator {

	BidirectionalGraph<Pair<Integer, Integer>> generateTilesGraph(RoomDesign room);
	
}
