using System;
using System.Collections.Generic;
using System.Text;
using dynamicBody.bullet;
using dynamicBody.character.health;
using dynamicBody.character.player.inventory;
using dynamicBody.character.player.movement;
using dynamicBody.character.player.shoot;
using dynamicBody.move;
using main.worldModel;

namespace dynamicBody.character.player
{
    /// <summary>
    /// Class that implements interface Player used to define all the aspects concerning the player
    /// </summary>
    public class Player : IPlayer
    {
        private int level;
        private bool clearRoom;
        private int playerSpeed;
        private int damage;
        private int rateOfFire;
        private ValueTuple<int, int> position;
        private Direction direction;
        private IMovement move;
        private IHealth health;
        private Inventory inventory;
        private IShootingPlayer bullet;
        private ISet<IBullet> roomBullets =  new HashSet<IBullet>();

        /// <summary>
        /// Default constructor
        /// </summary>
        /// <param name="pos"> player's position </param>
        /// <param name="dir" player's direction ></param>
        /// <param name="level"> player's starting level </param>
        public Player(ValueTuple<int, int> pos, Direction dir, int level)
        {
            this.position = pos;
            this.level = level;
            this.direction = dir;
            this.playerSpeed = 2;
            this.rateOfFire = 800;
            this.damage = 10;
            this.inventory = new Inventory(this);
            this.health = new Health(100);
            this.clearRoom = false;
        }

        public int GetCurrentHealth()
        {
            return this.health.GetCurrentHealth();
        }

        public int GetDamage()
        {
            return this.damage;
        }

        public Direction GetDirection()
        {
            return this.direction;
        }

        public IInventory GetInventory()
        {
            return this.inventory;
        }

        public int GetLevel()
        {
            return this.level;  
        }

        public int GetMaxHealth()
        {
            return this.health.GetMaxHealth();
        }

        public IMovement GetMove()
        {
            return this.move;
        }

        public int GetPlayerSpeed()
        {
            return this.playerSpeed;
        }

        public ValueTuple<int, int> GetPosition()
        {
            return this.position;
        }

        public int GetRateOfFire()
        {
            return this.rateOfFire;   
        }

        public ISet<IBullet> GetRoomBullets()
        {
            return this.roomBullets;
        }

        public IShootingPlayer GetShootingBullet()
        {
            return this.bullet;
        }

        public void Heal(int heal)
        {
            this.health.Heal(heal);
        }

        public bool IsAlive()
        {
            return this.health.IsAlive();
        }

        public void ResetStats()
        {
            this.playerSpeed = 2;
            this.rateOfFire = 800;
            this.damage = 10;
            this.inventory = new Inventory(this);
            this.health = new Health(100);
        }

        public void SetClearRoom(bool clearRoom)
        {
            this.clearRoom = clearRoom;
        }

        public void SetLevel(int level)
        {
            this.level = level;
        }

        public void TakeDamage(int damage)
        {
            this.health.TakeDmg(damage);
        }

        public void TransitionPos(ValueTuple<int, int> position)
        {
            this.position = position;
        }

        public void UpgradeDamage(int upgrade)
        {
            this.damage = this.damage + upgrade;
        }

        public void UpgradeMaxHealth(int upgrade)
        {
            this.health.UpgradeMaxHealth(upgrade);
        }

        public void UpgradePlayerSpeed(int upgrade)
        {
            this.playerSpeed = this.playerSpeed + upgrade;
        }

        public void UpgradeRateOfFire(int upgrade)
        {
            this.rateOfFire = this.rateOfFire - upgrade;
        }
    }
}