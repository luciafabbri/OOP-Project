using System;
using System.Collections.Generic;
using System.Text;
using Model.DynamicBody.Move;

namespace Model.DynamicBody.Character.Enemy.Move
{
	public interface IEnemyMovement
	{

		/// <summary>
		/// Method use to get the next position of enemy
		/// </summary>
		/// <param name="pos"> Position of enemy</param>
		/// <param name="speed">speed of enemy</param>
		/// <param name="dir">direction of enemy</param>
		/// <returns>a Pair with next enemy's coordination</returns>
		public ValueTuple<int, int> NextPos(ValueTuple<int, int> pos, int speed, Direction.EnumDirection dir);

		/// <summary>
		/// Method use to get the new direction of monster
		/// </summary>
		/// <returns>the new Direction</returns>
		public Direction.EnumDirection GetDirection();

	}
}
