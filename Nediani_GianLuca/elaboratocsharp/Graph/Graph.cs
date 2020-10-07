using System;
using System.Collections.Generic;


namespace elaboratocsharp
{
    /// <summary>An interface that defines a generic graph and 
    /// its basic operations</summary>
    /// <param><T> is the nodes' type</param> 
    public interface Graph<T>
    {
	    ///<param name="n">node to be added</param>
        void AddNode(T n);

        /// <param name="source"> source of the edge</param>
        /// <param name="destination"> destination of the edge</param>
        void AddEdge(T source, T destination);

        /// <param name="n"> node to be searched</param>
        /// <returns>true if node n is present in the graph</returns> 
        bool HasNode(T n);

        /// <param name = "source" > source of the edge</param>
        /// <param name="destination"> destination of the edge</param>
        /// <returns>true if an edge connecting source and destination is present</returns> 
        bool HasEdge(T source, T destination);

        /// <param name="n"></param>	 
        /// <returns> a list of all edges of node n</returns>
        List<T> GetEdges(T n);

        /// <returns> a set containing all the nodes in the graph</returns>
        HashSet<T> GetNodes();
    }

}
