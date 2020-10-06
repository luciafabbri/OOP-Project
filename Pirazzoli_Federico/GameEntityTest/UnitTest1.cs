using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

using gameEntities;
using gameEntities.modifiers;
using design.utilities;
using design.enums;


namespace GameEntityTest
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestMethod1()
        {
            ModifiersImpl ent1 = new HealthUpgrade1(new Pair<int, int>(0, 0));
            ModifiersImpl ent2 = new AttackSpeed1(new Pair<int, int>(64, 64));

            Assert.AreEqual(ent1.GetEnt(), Entities.HEALTHUPGRADE1);
            Assert.AreEqual(ent1.GetPos(), new Pair<int, int>(0, 0));
            Assert.AreEqual(ent1.GetStat(), Stats.HEALTH);

            Assert.AreEqual(ent2.GetEnt(), Entities.ATTACKSPEED1);
            Assert.AreEqual(ent2.GetPos(), new Pair<int, int>(64, 64));
            Assert.AreEqual(ent2.GetStat(), Stats.PROJ_SPEED);


            ItemImpl item1 = new Key(new Pair<int, int>(128, 128));
            ItemImpl item2 = new Coin(new Pair<int, int>(192, 192));

            Assert.AreEqual(item1.GetEnt(), Entities.KEY);
            Assert.AreEqual(item1.GetPos(), new Pair<int, int>(128, 128));
            
            Assert.AreEqual(item2.GetEnt(), Entities.COIN);
            Assert.AreEqual(item2.GetPos(), new Pair<int, int>(192, 192));

        }
    }
}
