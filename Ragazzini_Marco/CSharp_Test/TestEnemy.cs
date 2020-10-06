using Microsoft.VisualStudio.TestTools.UnitTesting;
using Model.DynamicBody.Character.Enemy;
using Model.DynamicBody.Move;
using System;

namespace CSharp_Test
{
    ///<summary>
    ///Class that tests the color of the nutrition filter entities.
    ///</summary>

    [TestClass]
    public class TestEnemy
    {   ///<summary>
        ///Method that tests the color of EMPTY SQUARE, STONE ENTITY, CELL DEAD.
        ///</summary>
        [TestMethod]
        public void TestStartPlayer()
        {
            IEnemy testEnemy = new EnemyImpl(new ValueTuple<int, int>(128, 128), 10, 1, 100, Direction.EnumDirection.SOUTH);
		    Assert.IsTrue(testEnemy.IsAlive());
            testEnemy.TakeDamage(30);
		    Assert.IsTrue(testEnemy.IsAlive());
            Assert.AreEqual(new ValueTuple<int, int>(128, 128), testEnemy.GetPosition());
		    Assert.AreEqual(Direction.EnumDirection.SOUTH, testEnemy.GetDirection());
            testEnemy.TakeDamage(70);
		    Assert.IsFalse(testEnemy.IsAlive());
        }
    }
}

