using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace elaboratocsharp
{
    class Test
    {
        // Main Method 
        static public void Main(String[] args)
        {
            Console.WriteLine("Main Method");
            Graph<int> testGraph = new BidirectionalGraph<int>();
            testGraph.AddNode(1);
            testGraph.AddNode(2);
            testGraph.AddNode(3);
            testGraph.AddEdge(1, 2);
            testGraph.AddEdge(2, 3);
            foreach( int n in testGraph.GetNodes())
            {
                Console.Write(n + " ");
            }
            Console.WriteLine("");

            foreach (int edge in testGraph.GetEdges(1))
            {
                Console.Write("Node one has edges to: " + edge);
            }

            Console.WriteLine("Is node one present in the graph?" + testGraph.HasNode(1));
            Console.WriteLine("Node one has edge to node three? " + testGraph.HasEdge(1, 3));

        }
    }
}
