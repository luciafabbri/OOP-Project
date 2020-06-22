package main.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node<T> {
    
    private T name;
     
    private List<Node<T>> shortestPath = new LinkedList<>();
     
    private Integer distance = Integer.MAX_VALUE;
     
    Map<Node<T>, Integer> adjacentNodes = new HashMap<>();
 
    public void addDestination(Node<T> destination, int distance) {
        adjacentNodes.put(destination, distance);
    }
  
    public Node(T name) {
        this.name = name;
    }

	public T getName() {
		return name;
	}

	public List<Node<T>> getShortestPath() {
		return shortestPath;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setName(T name) {
		this.name = name;
	}

	public void setShortestPath(List<Node<T>> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Map<Node<T>, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(Map<Node<T>, Integer> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}
     
    // getters and setters
}
