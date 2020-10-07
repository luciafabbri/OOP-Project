using System;
using System.Collections.Generic;
using System.Text;

namespace dynamicBody.character.health
{
    /// <summary>
    /// Class that implements interface Health used to represent all the characters's health aspects in the dungeon
    /// </summary>
    class Health : IHealth
    {
        private int maxHealth;
        private int currentHealth;

        /// <summary>
        ///  Default constructor  
        /// </summary>
        /// <param name="health"> character's initial healt</param>
        public Health(int health)
        {
            this.maxHealth = health;
            this.currentHealth = health;
        }

        /// <summary>
        /// Method used to get player's max health 
        /// </summary>
        /// <returns> param used to get player's max health </returns>
        public int GetMaxHealth()
        {
            return this.maxHealth;
        }

        /// <summary>
        /// Method used to get player's current health 
        /// </summary>
        /// <returns> param used to get player's current health </returns>
        public int GetCurrentHealth()
        {
            return this.currentHealth;
        }

        /// <summary>
        /// Method used to set player's current health 
        /// </summary>
        /// <param name="health"> param used to set player's current health </param>
        public void SetCurrentHealth(int health)
        {
            this.currentHealth = health;
        }

        /// <summary>
        /// Method used to update player's current health after an enemy attack 
        /// </summary>
        /// <param name="damage"> param to be subtracted to player's current health </param>
        public void TakeDmg(int damage)
        {
            this.currentHealth = this.currentHealth - damage;
        }

        /// <summary>
        /// Method used to check if the player is still alive 
        /// </summary>
        /// <returns> true if the player is still alive </returns>
        public bool IsAlive()
        {
            return this.currentHealth > 0;
        }

        /// <summary>
        /// Method used to upgrade player's max health 
        /// </summary>
        /// <param name="upgrade"> value to be added to player's max health </param>
        public void UpgradeMaxHealth(int upgrade)
        {
            this.maxHealth = this.maxHealth + upgrade;
        }

        /// <summary>
        /// Method used to upgrade player's current health 
        /// </summary>
        /// <param name="heal"> value to be added to player's current health </param>
        public void Heal(int heal)
        {
            this.currentHealth = this.currentHealth + heal;
            if (this.currentHealth > this.maxHealth)
            {
                this.currentHealth = this.maxHealth;
            }
        }
    }
}
