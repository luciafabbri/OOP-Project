using elaboratocsharp;
using System;
using System.Collections.Generic;

namespace ElaboratoCore
{
    /// <summary>
    /// Class with main method and use of graph generation and exploration
    /// </summary>
    class MainClass
    {
        // Main Method 
        static public void Main(String[] args)
        {
            Console.WriteLine("Main Method");
            GraphGenerator<int> graphGen = new GraphGeneratorInteger<int>();
            List<int> list = new List<int>();
            for(int i = 0; i < 5; i++)
            {
                list.Add(i);
            }
            Graph<int> graph = graphGen.GenerateGraph(list);

            foreach(int elem in graph.GetNodes())
            {
                Console.Write("Node " + elem + " has edges: ");
                foreach(int edge in graph.GetEdges(elem))
                {
                    Console.Write(edge + " ");
                }
                Console.WriteLine("");
            }
        }
    }
}

