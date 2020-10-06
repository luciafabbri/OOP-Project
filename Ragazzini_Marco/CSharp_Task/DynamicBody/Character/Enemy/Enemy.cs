using System;
using System.Collections.Generic;
using System.Text;

namespace Model.DynamicBody.Character.Enemy
{
	public interface IEnemy : ICharacter
    {
		/// <summary>
		/// Update the position of the enemy
		/// </summary>
		public void UpdatePos();

	}
}
