using System;
using System.Collections.Generic;
using System.Text;

namespace dynamicBody.character.health
{
    /// <summary>
    /// An interface that defines all the aspects of the class Health, used to get information about dynamic body's health 
    /// </summary>
    public interface IHealth 
    {
        /// <summary>
        /// Method used to get dynamic body's current health
        /// </summary>
        /// <returns> the value of the dynamic body's current health </returns>
        int GetCurrentHealth();

        /// <summary>
        /// Method used to get dynamic body's current health
        /// </summary>
        /// <param name="damage">  an int value to be subtracted to the dynamic body's current health </param>
        void TakeDmg(int damage);

        /// <summary>
        /// Method used to check if the dynamic body is still alive
        /// </summary>
        /// <returns> true if dynamic body's health value is greater than 0 </returns>
        bool IsAlive();

        /// <summary>
        /// Method used to check if the dynamic body is still alive
        /// </summary>
        /// <returns> the value of the dynamic body's max health </returns>
        int GetMaxHealth();

        /// <summary>
        /// Method used to set player's current health
        /// </summary>
        /// <param name="health"> an int value to be subtracted to the dynamic body's current health </param>
        void SetCurrentHealth(int health);

        /// <summary>
        /// Method used to upgrade player's max health
        /// </summary>
        /// <param name="upgrade"> an int value to be added to the dynamic body's max health </param>
        void UpgradeMaxHealth(int upgrade);

        /// <summary>
        /// Method used to cure and update player's current health 
        /// </summary>
        /// <param name="heal"> an int value to be added to the dynamic body's current life </param>
        void Heal(int heal);
    }
}
