using System;

namespace dynamicBody.move
{
    /// <summary>
    /// An interface used to set next dynamic body's coordinates and direction in the dungeon
    /// </summary>
    public interface IMovePos
    {
        /// <summary>
        /// Method used to get next possible dynamic body's position
        /// </summary>
        /// <param name="pos"> dynamic body's current coordinates </param>
        /// <param name="dir"> dynamic body's current direction </param>
        /// <returns>  the possible next dynamic body's coordinates and direction </returns>
        ValueTuple<int, int> NextPos(ValueTuple<int, int> pos, Direction dir);
    }
}

