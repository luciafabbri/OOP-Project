package dynamicBody.character.enemy.move;

import coordination.StateCoord;
import design.RoomDesign;
import design.utilities.Pair;
import design.utilities.graphs.BidirectionalGraph;
import design.utilities.graphs.Graph;
import dijkstra.DijkstraAlg;
import dijkstra.Node;
import dynamicBody.character.Character;
import dynamicBody.character.player.Player;
import dynamicBody.move.Direction;

/**
 * Class that implement MovePosMonster use when enemy's movement is and ToPlayer
 */
public class ToPlayerMove implements MovePosMonster {

	private boolean inizialized = false;
	private Player player = StateCoord.getPlayer();
	private Pair<Integer, Integer> checkPlayer = player.getPosition();

	private Direction nextDir;
	private RoomDesign currentRoom;
	private MovePosMonster move;
	private Character character;

	private Graph<Node<Pair<Integer, Integer>>> graph;

	/**
	 * Default constructor
	 * 
	 * @param room,      room where character is
	 * @param character, the character who need to move
	 */
	public ToPlayerMove(RoomDesign room, Character character) {
		currentRoom = room;
		this.character = character;
		move = new StraightMove(room, character);
	}

	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, int speed, Direction dir) {

		Pair<Integer, Integer> enemyDownRight = new Pair<>(pos.getX() + character.getDimension().getRight() - 1,
				pos.getY() + character.getDimension().getDown() - 1);
		Pair<Integer, Integer> enemyUpLeft = new Pair<>(pos.getX() + character.getDimension().getLeft() - 1,
				pos.getY() + character.getDimension().getUp() - 1);

		if (!checkPlayer.equals(ToPlayerUtil.findTile(ToPlayerUtil.getPlayerPos())) || !inizialized) {
			this.buildGraph();
			checkPlayer = ToPlayerUtil.findTile(ToPlayerUtil.getPlayerPos());
			inizialized = true;
		}

		if (ToPlayerUtil.findNode(ToPlayerUtil.findTile(enemyDownRight), graph).getShortestPath().isEmpty()
				|| ToPlayerUtil.findNode(ToPlayerUtil.findTile(enemyUpLeft), graph).getShortestPath().isEmpty()) {
			nextDir = dir;
			return pos;
		}
		nextDir = ToPlayerUtil.findDir(enemyUpLeft, enemyDownRight, graph);

		Pair<Integer, Integer> nextPos = move.nextPos(pos, speed, nextDir);
		return nextPos;

	}

	@Override
	public Direction getDirection() {
		if (nextDir == null) {
			throw new IllegalStateException(" Direction isn't Initialized ");
		}
		return nextDir;
	}
	
	private void buildGraph() {
		graph = this.createGraph(currentRoom);
		graph = DijkstraAlg.calculateShortestPathFromSource(graph, ToPlayerUtil.findNode(ToPlayerUtil.findTile(ToPlayerUtil.getPlayerPos()), graph));
	}
	
	private Graph<Node<Pair<Integer, Integer>>> createGraph(RoomDesign room) {
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
				x.addDestination(ToPlayerUtil.findNode(y, graph), 1);
			});
		});

		return graph;
	}
}
