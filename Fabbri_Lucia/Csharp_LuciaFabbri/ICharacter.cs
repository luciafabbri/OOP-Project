using System;
using System.Collections.Generic;
using System.Text;
using dynamicBody.move;
using dynamicBody.bullet;

namespace dynamicBody.character
{
    /// <summary>
    /// An interface that extends interface DynamicBody in order to add new methods and get information about characters 
    /// </summary>
    public interface ICharacter : IDynamicBody
    {
        /// <summary>
        ///  Method used to get character's coordinates
        /// </summary>
        /// <returns> character's coordinates </returns>
        ValueTuple<int, int> GetPosition();

        /// <summary>
        /// Method used to get character's current direction
        /// </summary>
        /// <returns> character's direction </returns>
        Direction GetDirection();

        /// <summary>
        /// Method used to take character's damage from any other entity
        /// </summary> 
        /// <param name="damage"> int value to subtract to character's current health </param>
        void TakeDamage(int damage);

        /// <summary>
        /// Method used to get character's bullet set 
        /// </summary>
        /// <returns> character's bullet set </returns>
        ISet<IBullet> GetRoomBullets();
    }
}
