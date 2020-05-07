package dynamicBody.character.enemy.move;

import design.RoomDesign;
import design.utilities.Pair;
import design.utilities.graphs.Graph;
import dijkstra.DijkstraAlg;
import dijkstra.Node;
import dynamicBody.character.Character;
import dynamicBody.move.Direction;

/**
 * Class that implement MovePosMonster use when enemy's movement is and ToPlayer
 */
public class ToPlayerMove extends ToPlayerAbs implements MovePosMonster {

	private boolean inizialithed = false;
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

		if (!inizialithed) {
			graph = createGraph(currentRoom);
			graph = DijkstraAlg.calculateShortestPathFromSource(graph, findNode(findTile(getPlayerPos()), graph));
			nextDir = dir;
			inizialithed = true;
		}

		if (!checkPlayer.equals(findTile(getPlayerPos()))) {
			graph = createGraph(currentRoom);
			graph = DijkstraAlg.calculateShortestPathFromSource(graph, findNode(findTile(getPlayerPos()), graph));
			checkPlayer = findTile(getPlayerPos());
		}

		if (findNode(findTile(enemyDownRight), graph).getShortestPath().isEmpty()
				|| findNode(findTile(enemyUpLeft), graph).getShortestPath().isEmpty()) {
			nextDir = dir;
			return pos;
		}
		nextDir = findDir(enemyUpLeft, enemyDownRight, graph);

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

}
