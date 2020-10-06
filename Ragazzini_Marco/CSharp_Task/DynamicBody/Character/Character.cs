using System;
using System.Collections.Generic;
using System.Text;
using Model.DynamicBody.Move;

namespace Model.DynamicBody.Character
{
	public interface ICharacter : IDynamicBody
    {
		/// <summary>
		/// Get the position of a Dynamic Body
		/// </summary>
		/// <returns>character's coordinates </returns>
		ValueTuple<int, int> GetPosition();

		/// <summary>
		/// Get the direction of a Dynamic Body
		/// </summary>
		/// <returns>character's direction </returns>
		Direction.EnumDirection GetDirection();

		/// <summary>
		/// Method used to take character's damage from any other entity
		/// </summary>
		/// <param name="damage">an int value to subtract to character's current health</param>
		void TakeDamage(int damage);
	}
}
