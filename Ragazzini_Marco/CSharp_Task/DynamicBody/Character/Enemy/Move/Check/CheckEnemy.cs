using System;
using System.Collections.Generic;
using System.Text;
using Model.DynamicBody.Move;

namespace Model.DynamicBody.Character.Enemy.Move.Check
{
	public interface ICheckEnemy : ICheckPos
    {
		/// <summary>
		/// Methods use to change the Direction of monster
		/// </summary>
		/// <param name="pos">position of monster</param>
		/// <param name="dir">direction of monster</param>
		/// <returns>a new Direction </returns>
		public Direction.EnumDirection ChangeDir(ValueTuple<int, int> pos, Direction.EnumDirection dir);
	}
}
