using elaboratocsharp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ElaboratoCore
{
    /// <summary>
    /// Implementation of GraphGenerator that generates random
    /// graphs out of lists of integers. The nodes are of type int.
    /// </summary>
    class GraphGeneratorInteger<T> : GraphGenerator<int>
    {
        private Random random = new Random();
        private BreadthFirstSearch<int> bfs = new BreadthFirstSearch<int>();

        public BidirectionalGraph<int> GenerateGraph(List<int> nodesList)
        {
            BidirectionalGraph<int> graph = new BidirectionalGraph<int>();

            foreach (int elem in nodesList)
            {
                graph.AddNode(elem);
            }

            foreach (int elem in graph.GetNodes())
            {
                int numOfRemainingEdges = random.Next(4) + 1;
                while(graph.GetEdges(elem).Count() < 1 )
                {
                    int randomNodeIndex = random.Next(nodesList.Count());
                    if (randomNodeIndex != elem && !graph.GetEdges(elem).Contains(randomNodeIndex))
                    {
                        if (graph.GetEdges(randomNodeIndex).Count() < 4)
                        {
                            graph.AddEdge(elem, randomNodeIndex);
                            numOfRemainingEdges--;
                        }
                    }
                }
            }
            while (!bfs.AllNodesReachable(graph))
            {
                return GenerateGraph(nodesList);
            }
            return graph;
        }
    }
}
