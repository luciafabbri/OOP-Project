package dynamicBody.character.enemy.move;

import coordination.StateCoord;
import design.RoomDesign;
import design.utilities.GameSettings;
import design.utilities.Pair;
import design.utilities.graphs.BidirectionalGraph;
import design.utilities.graphs.Graph;
import dijkstra.Node;
import dynamicBody.character.player.Player;
import dynamicBody.move.Direction;

public class ToPlayerAbs {

	private Direction lastDir;

	protected Player player = StateCoord.getPlayer();

	private int disPX = (player.getDimension().getRight() + player.getDimension().getLeft()) / 2;
	private int disPY = (player.getDimension().getUp() + player.getDimension().getDown()) / 2;

	protected Pair<Integer, Integer> findTile(Pair<Integer, Integer> pos) {
		int x = pos.getX() / GameSettings.TILESIZE;
		int y = pos.getY() / GameSettings.TILESIZE;
		return new Pair<Integer, Integer>(x * GameSettings.TILESIZE, y * GameSettings.TILESIZE);
	}

	protected Direction findDir(Pair<Integer, Integer> pos1, Pair<Integer, Integer> pos2,
			Graph<Node<Pair<Integer, Integer>>> graph) {
		Direction dir;

		int size1 = findNode(findTile(pos1), graph).getShortestPath().size() - 1;
		Pair<Integer, Integer> checkPos1 = findNode(findTile(pos1), graph).getShortestPath().get(size1).getName();

		int size2 = findNode(findTile(pos2), graph).getShortestPath().size() - 1;
		Pair<Integer, Integer> checkPos2 = findNode(findTile(pos2), graph).getShortestPath().get(size2).getName();

		if (checkPos1.equals(checkPos2)) {
			if (pos1.getX() < checkPos1.getX()) {
				dir = Direction.EAST;
			} else if (pos1.getX() > checkPos1.getX()) {
				dir = Direction.WEST;
			} else if (pos1.getY() < checkPos1.getY()) {
				dir = Direction.SOUTH;
			} else if (pos1.getY() > checkPos1.getY()) {
				dir = Direction.NORTH;
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			dir = lastDir;
		}
		lastDir = dir;
		return dir;

	}

	protected Node<Pair<Integer, Integer>> findNode(Pair<Integer, Integer> pos,
			Graph<Node<Pair<Integer, Integer>>> graph) {
		for (Node<Pair<Integer, Integer>> node : graph.getNodes()) {
			if (node.getName().equals(pos)) {
				return node;
			}
		}
		return null;
	}

	protected Graph<Node<Pair<Integer, Integer>>> createGraph(RoomDesign room) {
		Graph<Node<Pair<Integer, Integer>>> graph = new BidirectionalGraph<>();
		// INSERISCO NODI DENTRO AL GRAFO
		room.getTilesGraph().getNodes().forEach(x -> {
			if (!room.getObstaclePositions().contains(x)) {
				graph.addNode(new Node<Pair<Integer, Integer>>(x));
			}
		});
		// System.out.println(graph.getNodes().size());
		// SETTO I NODI ADIANCENTI IN TUTTI I NODI
		graph.getNodes().forEach(x -> {
			room.getTilesGraph().getEdges(x.getName()).forEach(y -> {
				x.addDestination(findNode(y, graph), 1);
			});
		});

		return graph;
	}

	protected Pair<Integer, Integer> getPlayerPos() {
		return new Pair<>(player.getPosition().getX() + disPX, player.getPosition().getY() + disPY);
	}

}
