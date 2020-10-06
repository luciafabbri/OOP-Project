using System;
using System.Collections.Generic;
using System.Text;

namespace Model.DynamicBody.Move
{
	public interface ICheckPos
	{
		/// <summary>
		/// Based on dynamic body's current coordinates, this method checks if the next ones are not occupied 
		/// by any other object in the dungeon
		/// </summary>
		/// <param name="pos">pos, dynamic body's current coordinates </param>
		/// <returns>true if the dynamic body could move in its next position</returns>
		public Boolean PossiblePos(ValueTuple<int, int> pos);
	}
}
