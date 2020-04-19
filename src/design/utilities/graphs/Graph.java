package design.utilities.graphs;

import java.util.*;

public interface Graph<T> {
	
	void addNode(T n);
	
	void addEdge(T source, T destination);
	
	boolean hasNode(T n);
	
	boolean hasEdge(T source, T destination);
	
	List<T> getEdges(T n);
	
	Set<T> getNodes();
}
