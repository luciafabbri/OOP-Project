using System;
using System.Collections.Generic;
using System.Text;

namespace dynamicBody.character.player.inventory
{
    /// <summary>
    ///  Class that implements interface Inventory used to manage all the player's objects picked up in each room
    /// </summary>
    class Inventory : IInventory
    {
        private int coin;
        private int key;

        /// <summary>
        ///  Default constructor
        /// <paramref name="player"/> player, the player of which we will store the picked objects
        /// </summary>
        public Inventory(IPlayer player)
        {
            this.coin = 0;
            this.key = 0;
        }

        /// <summary>
        ///  Method used to get player's keys
        /// </summary>
        /// <returns>  player's coins </returns>
        public int GetCoin()
        {
            return this.coin;
        }

        /// <summary>
        /// Method used to get player's keys
        /// </summary>
        /// <returns>  player's keys </returns>
        public int GetKey()
        {
            return this.key;
        }

        /// <summary>
        /// Method used to add a new coin to the inventory
        /// </summary>
        public void AddCoin()
        {
            this.coin += 1;
        }

        /// <summary>
        /// Method used to add a new key to the inventory
        /// </summary>
        public void AddKey()
        {
            this.key += 1;
        }
    }
}
