package dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

import design.utilities.Pair;
import design.utilities.graphs.Graph;

public class DijkstraAlg {
	
	public static Graph<Node<Pair<Integer, Integer>>> calculateShortestPathFromSource(Graph<Node<Pair<Integer, Integer>>> graph, Node<Pair<Integer, Integer>> source) {
	    source.setDistance(0);
	 
	    Set<Node<Pair<Integer, Integer>>> settledNodes = new HashSet<>();
	    Set<Node<Pair<Integer, Integer>>> unsettledNodes = new HashSet<>();
	 
	    unsettledNodes.add(source);
	 
	    while (unsettledNodes.size() != 0) {
	        Node<Pair<Integer, Integer>> currentNode = getLowestDistanceNode(unsettledNodes);
	        unsettledNodes.remove(currentNode);
	        for (Entry <Node<Pair<Integer, Integer>>, Integer> adjacencyPair: 
	          currentNode.getAdjacentNodes().entrySet()) {
	            Node<Pair<Integer, Integer>> adjacentNode = adjacencyPair.getKey();
	            Integer edgeWeight = adjacencyPair.getValue();
	            if (!settledNodes.contains(adjacentNode)) {
	                calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
	                unsettledNodes.add(adjacentNode);
	            }
	        }
	        settledNodes.add(currentNode);
	    }
	    return graph;
	}
	
	private static Node<Pair<Integer, Integer>> getLowestDistanceNode(Set < Node<Pair<Integer, Integer>> > unsettledNodes) {
	    Node<Pair<Integer, Integer>> lowestDistanceNode = null;
	    int lowestDistance = Integer.MAX_VALUE;
	    for (Node<Pair<Integer, Integer>> node: unsettledNodes) {
	        int nodeDistance = node.getDistance();
	        if (nodeDistance < lowestDistance) {
	            lowestDistance = nodeDistance;
	            lowestDistanceNode = node;
	        }
	    }
	    return lowestDistanceNode;
	}
	
	private static void calculateMinimumDistance(Node<Pair<Integer, Integer>> evaluationNode, Integer edgeWeigh, Node<Pair<Integer, Integer>> sourceNode) {
	    Integer sourceDistance = sourceNode.getDistance();
	    if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
	        evaluationNode.setDistance(sourceDistance + edgeWeigh);
	        LinkedList<Node<Pair<Integer, Integer>>> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
	        shortestPath.add(sourceNode);
	        evaluationNode.setShortestPath(shortestPath);
	    }
	}

}
