package design.utilities.graphs;

import java.util.*;

public class BreadthFirstSearch<T> {
	
	public boolean isReachable(Graph<T> graph, T source, T destination) {
		
		Map<T, Boolean> map = new HashMap<>();
		graph.getNodes().forEach(n -> {
			map.put(n, false);
		});
		
		LinkedList<T> queue = new LinkedList<T>();
		
		map.put(source, true);
		queue.add(source);
		
		Iterator<T> iterator;
		
		while(queue.size()!= 0) {
			
			 // Dequeue a vertex from queue and print it 
			source = queue.poll();
			
            T n; 
            iterator = graph.getEdges(source).listIterator(); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            while (iterator.hasNext()) 
            { 
                n = iterator.next(); 
  
                // If this adjacent node is the destination node, 
                // then return true 
                if (source.equals(destination)) 
                    return true; 
  
                // Else, continue to do BFS 
                if (!map.get(n)) 
                { 
                    map.put(n, true); 
                    queue.add(n); 
                } 
            } 
        } 
  
        // If BFS is complete without visited d 
        return false; 
    } 

}
