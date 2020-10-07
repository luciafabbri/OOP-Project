using elaboratocsharp;
using System.Collections.Generic;

namespace ElaboratoCore
{
    /// <summary>
    /// Interface that defines a method to generate random graphs
    /// </summary>
    public interface GraphGenerator<T>
    {
        /// <param name = "nodesList" > list of elements of type T</param>
        /// <returns>A random graph where the nodes are the elements of the input list</returns> 
        BidirectionalGraph<T> GenerateGraph(List<T> nodesList);
    }
}
