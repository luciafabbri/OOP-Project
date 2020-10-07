using dynamicBody.character.player.inventory;
using dynamicBody.character.player.movement;
using dynamicBody.character.player.shoot;
using main.worldModel;
using System;
using System.Collections.Generic;
using System.Text;

namespace dynamicBody.character.player
{
    /// <summary>
    /// An interface that presents all the methods needed or that can be used with regards to the player
    /// </summary>
    public interface IPlayer : ICharacter
    {       
        /// <summary>
        ///Method used to set the level in which the player should go
        /// </summary>
        /// <param name="level"> new level to be set </param>
        void SetLevel(int level);

        /// <summary>
        /// Method used to get player's current level ID
        /// </summary>
        /// <returns> player's current level ID </returns>
        int GetLevel();

        /// <summary>
        /// Method used to update player's position
        /// </summary>
        /// <param name="position"> the coordinates of the player to be set </param>
        void TransitionPos(ValueTuple<int, int> position);

        /// <summary>
        /// Method used the get player's current speed
        /// </summary>
        /// <returns> player's speed </returns>
        int GetPlayerSpeed();

        /// <summary>
        /// Method used to upgrade player's damage 
        /// </summary>
        /// <param name="upgrade"> an int value to add to player's current damage </param>
        void UpgradeDamage(int upgrade);

        /// <summary>
        /// Method used to get player's inventory
        /// </summary>
        /// <returns> player's inventory </returns>
        IInventory GetInventory();

        /// <summary>
        /// Method used to upgrade player's speed 
        /// </summary>
        /// <param name="upgrade"> an int value to be added to player's speed in order to move faster in the dungeon </param>
        void UpgradePlayerSpeed(int upgrade);

        /// <summary>
        /// Method used to get player's rate of fire 
        /// </summary>
        /// <returns> player's rate of fire </returns>
        int GetRateOfFire();

        /// <summary>
        /// Method used to check the presence of any enemy in the room
        /// If the room is empty, the doors will open and the player will be able to change room
        /// </summary>
        /// <param name="clearRoom"> the bool value to be checked </param>
        void SetClearRoom(bool clearRoom);

        /// <summary>
        /// Method used to upgrade player's rate of fire 
        /// </summary>
        /// <param name="upgrade"> an int value used to change player's current rate of fire in order to shoot faster </param>
        void UpgradeRateOfFire(int upgrade);

        /// <summary>
        /// Method used to upgrade player's max health 
        /// </summary>
        /// <param name="upgrade"> an int value to be added to the player's max health </param>
        void UpgradeMaxHealth(int upgrade);

        /// <summary>
        /// Method used to upgrade player's current health
        /// </summary>
        /// <param name="heal"> int value to be added to player's current health </param>
        void Heal(int heal);

        /// <summary>
        /// Method used to get player's current health
        /// </summary>
        /// <returns> player's current health </returns>
        int GetCurrentHealth();

        /// <summary>
        /// Method used to get player's max health
        /// </summary>
        /// <returns> player's max health </returns>
        int GetMaxHealth();

        /// <summary>
        ///  Method used to get player's type of shooting bullet
        /// </summary>
        /// <returns>  player's bullet </returns>
        IShootingPlayer GetShootingBullet();

        /// <summary>
        /// Method used to get player's movement (only used in class PlayerAndBulletCreationTest)
        /// </summary>
        /// <returns> new current player's coordinates and his direction </returns>
        IMovement GetMove();

        /// <summary>
        ///  Method used to reset player's stats
        /// </summary>
        void ResetStats();
    }
}