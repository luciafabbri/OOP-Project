using System;
using System.Collections.Generic;
using System.Text;

namespace dynamicBody.character.player.inventory
{
    /// <summary>
    /// An interface used to store objects that the player can pick up by walking into the environment
    /// </summary>
    public interface IInventory
    {
        /// <summary>
        /// <return> player's coins stored in the inventory </return>
        /// </summary>
        int GetCoin();

        /// <summary>
        /// <return> player's keys stored in the inventory </return>
        /// </summary>
        int GetKey();

        /// <summary>
        /// Method used to add a new coin in the inventory 
        /// </summary>
        void AddCoin();

        /// <summary>
        /// Method used to add a new key in the inventory
        /// </summary>
        void AddKey();
    }
}
