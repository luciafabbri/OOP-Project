using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using elaboratocsharp;
using System.Collections.Generic;

namespace ElaboratoTests
{
    /// <summary>
    /// Unit testing class for ElaboratoCore classes
    /// </summary>
    [TestClass]
    public class UnitTest
    {
        Graph<int> testGraph = new BidirectionalGraph<int>();
        BreadthFirstSearch<int> bfs = new BreadthFirstSearch<int>();
        HashSet<int> nodesSet = new HashSet<int>();

        [TestInitialize]
        public void TestInitialize()
        {
            nodesSet.Add(1);
            nodesSet.Add(2);
            nodesSet.Add(3);
            nodesSet.Add(4);
            foreach(int i in nodesSet)
            {
                testGraph.AddNode(i);
            }
            testGraph.AddEdge(1, 2);
            testGraph.AddEdge(2, 3);
        }


        [TestMethod]
        public void TestNodes()
        {
            Assert.IsTrue(testGraph.HasNode(1));
            Assert.AreEqual(nodesSet.Count, testGraph.GetNodes().Count);
        }

        [TestMethod]
        public void TestEdges()
        {
            Assert.AreEqual(testGraph.GetEdges(1).Count, 1);
            Assert.IsTrue(testGraph.HasEdge(1, 2));
            Assert.IsFalse(testGraph.HasEdge(1, 3));
        }

        [TestMethod]
        public void TestBFS()
        {
            Assert.IsTrue(bfs.IsReachable(testGraph, 1, 3));
            Assert.IsFalse(bfs.IsReachable(testGraph, 1, 4));
        }
    }
}
