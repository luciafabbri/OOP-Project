package dynamicBody.character.enemy.move;

import coordination.StateCoord;
import dijkstra.DijkstraAlg;
import dijkstra.Node;
import dynamicBody.character.Character;
import dynamicBody.character.player.Player;
import dynamicBody.move.Direction;
import worldModel.RoomModel;
import worldModel.utilities.Pair;
import worldModel.utilities.graphs.Graph;

/**
 * Class that implement EnemyMovement use when enemy's movement is and ToPlayer
 */
public class ToPlayerMove implements EnemyMovement {

	private boolean inizialized = false;
	private Player player = StateCoord.getPlayer();
	private Pair<Integer, Integer> checkPlayer = player.getPosition();

	private Direction nextDir;
	private RoomModel currentRoom;
	private EnemyMovement move;
	private Character character;

	private Graph<Node<Pair<Integer, Integer>>> graph;

	/**
	 * Default constructor
	 * 
	 * @param room,      room where character is
	 * @param character, the character who need to move
	 */
	public ToPlayerMove(RoomModel room, Character character) {
		currentRoom = room;
		this.character = character;
		move = new StraightMove(room, character);
	}

	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, int speed, Direction dir) {

		Pair<Integer, Integer> enemyDownRight = new Pair<>(pos.getX() + character.getDimension().getRight(),
				pos.getY() + character.getDimension().getDown());
		Pair<Integer, Integer> enemyUpLeft = new Pair<>(pos.getX() + character.getDimension().getLeft(),
				pos.getY() + 48);

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
		graph = ToPlayerUtil.createGraph(currentRoom);
		graph = DijkstraAlg.calculateShortestPathFromSource(graph,
				ToPlayerUtil.findNode(ToPlayerUtil.findTile(ToPlayerUtil.getPlayerPos()), graph));
	}
}
