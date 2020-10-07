using System;
using System.Collections.Generic;
using System.Text;

namespace dynamicBody
{
    /// <summary>
    /// An interface used to represent all the methods that are in common with all the dynamic bodies in the dungeon
    /// </summary>
    public interface IDynamicBody
    {
        /// <summary>
        /// Method used to get dynamic body's damage
        /// </summary>
        /// <returns> dynamic bodies's damage </returns>
        int GetDamage();

        /// <summary>
        /// Method used to check if dynamic body is alive
        /// </summary>
        /// <returns> true if the dynamic body is alive </returns>
        bool IsAlive();
    }
}
