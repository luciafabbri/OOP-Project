using System;
using dynamicBody.move;

namespace dynamicBody.bullet
{
    /// <summary>
    /// An interface that defines all the main methods concerning bullets
    /// </summary>
    public interface IBullet : IDynamicBody
    {
        /// <summary>
        /// Method used to know bullet's current position
        /// </summary>
        /// <returns> bullet's current position </returns>
        ValueTuple<int, int> GetPos();

        /// <summary>
        /// Method used to check if bullet's next coordinates are considered to be in a possible position
        /// </summary>
        void UpdatePos();

        /// <summary>
        /// Method used to know bullet's current direction
        /// </summary>
        /// <returns> bullet's current direction </returns>
        Direction GetDirection();

        /// <summary>
        /// Method used to know bullet's type
        /// </summary>
        /// <returns> bullet's type </returns>
        TypeBullet GetType();
    }
}

