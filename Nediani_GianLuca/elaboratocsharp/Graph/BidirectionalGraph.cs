using System;
using System.Collections.Generic;

namespace elaboratocsharp
{

    /// <summary>Bidirectional implementation of Graph<T> class</summary>
    /// <param name="T"> <T> is the nodes' type</param>
    public class BidirectionalGraph<T> : Graph<T>
    {

        private Dictionary<T, List<T>> graphMap = new Dictionary<T, List<T>>();

        public void AddEdge(T source, T destination)
        {
            List<T> list = new List<T>();
            if (!graphMap.TryGetValue(source, out list) || !graphMap.TryGetValue(destination, out list))
            { 
                throw new InvalidOperationException();
            }

            graphMap[source].Add(destination);
            graphMap[destination].Add(source);

        }

        public void AddNode(T n)
        {
            graphMap.Add(n, new List<T>());
        }

        public List<T> GetEdges(T n)
        {
            return graphMap[n];
        }

        public HashSet<T> GetNodes()
        {
            return new HashSet<T>(graphMap.Keys);
        }

        public bool HasEdge(T source, T destination)
        {

            return graphMap[source].Contains(destination);
        }

        public bool HasNode(T n)
        {
            return graphMap.ContainsKey(n);
        }
    }
}
