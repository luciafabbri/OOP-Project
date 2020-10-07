using dynamicBody.move;
using System;

namespace dynamicBody.character.player.movement
{
    /// <summary>
    /// An interface that allows the player to move in the environment by pressing keyboard's keys
    /// </summary>
	public interface IMovement
	{
        /// <summary>
        /// Method used to get player's direction
        /// </summary>
        /// <returns>  player's direction </returns>
        Direction GetDirection();
    }
}
