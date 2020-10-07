using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace elaboratocsharp
{
    /// <summary>
    /// A class containing methods to explore a graph of type
    /// ElaboratoCore.Graph<T> via Breadth First Search
    /// </summary>
    /// <typeparam name="T">the nodes' type</typeparam>
    public class BreadthFirstSearch<T>
    {
        /// <param name="graph">graph to be searched</param>
        /// <param name="source">source of the path</param>
        /// <param name="destination">destination of the path</param>
        /// <returns>true if a path from source to destination is present in the graph</returns>
        public bool IsReachable(Graph<T> graph, T source, T destination)
        {

            Dictionary<T, bool> map = new Dictionary<T, bool>();

            foreach(T n in graph.GetNodes())
            {
                map.Add(n, false);
            }

            LinkedList<T> queue = new LinkedList<T>();

            map[source] = true;
            queue.AddLast(source);

            IEnumerable<T> iterator;

            while (queue.Count() != 0)
            {

                source = queue.First();
                queue.RemoveFirst();

                T n;
                iterator = graph.GetEdges(source).AsEnumerable();

                foreach (T p in graph.GetEdges(source))
                {
                    n = p;
                    if (source.Equals(destination))
                        return true;
                    if (!map[n])
                    {
                        map[n] = true;
                        queue.AddLast(n);
                    }
                }
            }

            return false;
        }

        /// <param name="graph">graph to be searched</param>
        /// <returns>true if a path from any node to any node is present in the graph</returns>
        public Boolean AllNodesReachable(Graph<T> graph)
        {
            foreach (T node1 in graph.GetNodes())
            {
                foreach (T node2 in graph.GetNodes())
                {
                    if (!IsReachable(graph, node1, node2))
                    {
                        return false;
                    }
                }
            }
            return true;
        }
    }


}
