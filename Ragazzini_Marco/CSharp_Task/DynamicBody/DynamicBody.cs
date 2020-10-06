using System;
using System.Collections.Generic;
using System.Text;

namespace Model.DynamicBody
{
	/// <summary>
	/// An interface used to represent all the methods that are in common with all the dynamic bodies in the dungeon
	/// </summary>
	public interface IDynamicBody
    {
		/// <summary>
		/// Method that returns the dimensions of a DynamicBody
		/// </summary>
		/// <returns>UpDownLeftRight of Integer relative to the DinamicBody's dimension</returns>
		public UpDownLeftRight<int> GetDimension();

		/// <summary>
		/// Method that returns the damage's value of a DynamicBody
		/// </summary>
		/// <returns>dynamic bodies's damage</returns>
		public int GetDamage();

		/// <summary>
		/// Method that returns if the DynamicBody is alive
		/// </summary>
		/// <returns>true if the dynamic body is alive</returns>
		public Boolean IsAlive();
	}
}
