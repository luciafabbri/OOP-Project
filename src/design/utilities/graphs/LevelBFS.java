package design.utilities.graphs;

import design.RoomDesign;

/**
 * Extension of class BreadthFirstSearch used specifically to implement BFS
 * methods for the game's levels
 *
 */
/**
 * @author Gian Camion
 *
 */
public class LevelBFS extends BreadthFirstSearch<RoomDesign> {

	/**
	 * @param level graph to be checked
	 * @return true if from any room any other room is reachable inside the graph
	 */
	public boolean areRoomsReachable(BidirectionalGraph<RoomDesign> graph) {

		for (RoomDesign r : graph.getNodes()) {
			for (RoomDesign or : graph.getNodes()) {
				if (!this.isReachable(graph, r, or)) {
					return false;
				}
			}
		}
		return true;
	}

}
