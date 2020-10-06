using System;
using System.Collections.Generic;
using System.Text;

namespace Model.DynamicBody.Move
{
	public interface IMovePos
	{
		/// <summary>
		/// Method that returns next position
		/// </summary>
		/// <returns>the possible next dynamic body's coordinates and direction</returns>
		ValueTuple<int, int> NextPos(ValueTuple<int, int> pos, Direction dir);
	}
}
