package design.utilities.graphs;

import java.util.*;

public class BreadthFirstSearch<T> {

	public boolean isReachable(Graph<T> graph, T source, T destination) {

		final Map<T, Boolean> map = new HashMap<>();
		graph.getNodes().forEach(n -> {
			map.put(n, false);
		});

		final LinkedList<T> queue = new LinkedList<T>();

		map.put(source, true);
		queue.add(source);

		Iterator<T> iterator;

		while (queue.size() != 0) {

			source = queue.poll();

			T n;
			iterator = graph.getEdges(source).listIterator();

			while (iterator.hasNext()) {
				n = iterator.next();
				if (source.equals(destination))
					return true;
				if (!map.get(n)) {
					map.put(n, true);
					queue.add(n);
				}
			}
		}

		return false;
	}

}
