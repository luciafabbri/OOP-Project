package dynamicBody.character.enemy.move;

import design.RoomDesign;
import design.utilities.Pair;
import design.utilities.graphs.Graph;
import dijkstra.DijkstraAlg;
import dijkstra.Node;
import dynamicBody.character.Character;
import dynamicBody.move.Direction;

public class ToPlayerMove extends ToPlayerAbs implements MovePosMonster {

	private Direction nextDir = null;

	private RoomDesign currentRoom;

	private boolean inizialithed = false;

	private MovePosMonster move;

	private Graph<Node<Pair<Integer, Integer>>> graph;

	private Pair<Integer, Integer> checkPlayer = player.getPosition();

	private Character character;

	public ToPlayerMove(RoomDesign room, Character character) {
		currentRoom = room;
		this.character = character;
		move = new StraightMove(room, character);
	}

	@Override
	public Pair<Integer, Integer> nextPos(Pair<Integer, Integer> pos, int speed, Direction dir) {

		Pair<Integer, Integer> monsterDownRight = new Pair<>(pos.getX() + character.getDimension().getRight() - 1,
				pos.getY() + character.getDimension().getDown() - 1);
		Pair<Integer, Integer> monsterUpLeft = new Pair<>(pos.getX() + character.getDimension().getLeft() - 1,
				pos.getY() + character.getDimension().getUp() - 1);

		if (!inizialithed) {
			graph = createGraph(currentRoom);
			graph = DijkstraAlg.calculateShortestPathFromSource(graph, findNode(findTile(getPlayerPos()), graph));
			inizialithed = true;
		}

		if (!checkPlayer.equals(findTile(getPlayerPos()))) {
			graph = createGraph(currentRoom);
			graph = DijkstraAlg.calculateShortestPathFromSource(graph, findNode(findTile(getPlayerPos()), graph));
			checkPlayer = findTile(getPlayerPos());
		}

		if (findNode(findTile(monsterDownRight), graph).getShortestPath().isEmpty()
				|| findNode(findTile(monsterUpLeft), graph).getShortestPath().isEmpty()) {
			nextDir = dir;
			return pos;
		}
		nextDir = findDir(monsterUpLeft, monsterDownRight, graph);

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
