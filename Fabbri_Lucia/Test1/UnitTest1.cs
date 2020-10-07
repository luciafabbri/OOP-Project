using dynamicBody.character.player;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using dynamicBody.character.health;
using dynamicBody.character.player.inventory;
using dynamicBody.move;

namespace Test1
{
    /// <summary>
    /// Class test used to check player's functionalities
    /// </summary>
    [TestClass]
    public class PlayerTest
    {
        private static Player testPlayer = new Player(new ValueTuple<int, int>(64, 64), Direction.SOUTH, 0);

        /// <summary>
        /// Method used to test player's initial functionalities
        /// </summary>
        [TestMethod]
        public void InitialTest()
        {
            Assert.IsTrue(testPlayer.IsAlive());
            Assert.AreEqual(new ValueTuple<int, int>(64, 64), testPlayer.GetPosition());
            Assert.AreEqual(Direction.SOUTH, testPlayer.GetDirection());
            Assert.AreEqual(0, testPlayer.GetLevel());
        }

        /// <summary>
        /// Method used to test player's health 
        /// </summary>
        [TestMethod]
        public void HealthTest()
        {
            Assert.IsTrue(testPlayer.IsAlive());
            Assert.AreEqual(100, testPlayer.GetMaxHealth());
            Assert.AreEqual(100, testPlayer.GetCurrentHealth());
            testPlayer.TakeDamage(30);
            Assert.AreEqual(70, testPlayer.GetCurrentHealth());
            testPlayer.Heal(40);
            Assert.AreEqual(100, testPlayer.GetCurrentHealth());
            testPlayer.UpgradeMaxHealth(10);
            Assert.AreEqual(110, testPlayer.GetMaxHealth());
            testPlayer.TakeDamage(30);
            Assert.AreEqual(70, testPlayer.GetCurrentHealth());
            testPlayer.Heal(50);
            Assert.AreEqual(110, testPlayer.GetCurrentHealth());
        }

        /// <summary>
        /// Method used to test player's inventory 
        /// </summary>
        [TestMethod]
        public void InventoryTest()
        {
            Assert.IsTrue(testPlayer.IsAlive());
            Assert.AreEqual(0, testPlayer.GetInventory().GetCoin());
            Assert.AreEqual(0, testPlayer.GetInventory().GetKey());
            testPlayer.GetInventory().AddCoin();
            testPlayer.GetInventory().AddKey();
            Assert.AreEqual(1, testPlayer.GetInventory().GetKey());
            Assert.AreEqual(1, testPlayer.GetInventory().GetCoin());
            testPlayer.ResetStats();
            Assert.AreEqual(0, testPlayer.GetInventory().GetCoin());
            Assert.AreEqual(0, testPlayer.GetInventory().GetKey());
        }

        /// <summary>
        /// Method used to test player's upgrades 
        /// </summary>
        [TestMethod]
        public void UpgradeTest()
        {
            Assert.IsTrue(testPlayer.IsAlive());
            Assert.AreEqual(10, testPlayer.GetDamage());
            testPlayer.UpgradeDamage(20);
            Assert.AreEqual(30, testPlayer.GetDamage());
            Assert.AreEqual(2, testPlayer.GetPlayerSpeed());
            testPlayer.UpgradePlayerSpeed(10);
            Assert.AreEqual(12, testPlayer.GetPlayerSpeed());
            Assert.AreEqual(800, testPlayer.GetRateOfFire());
            testPlayer.UpgradeRateOfFire(500);
            Assert.AreEqual(300, testPlayer.GetRateOfFire());
            testPlayer.UpgradeMaxHealth(10);
            Assert.AreEqual(110, testPlayer.GetMaxHealth());
        }
    }
}
