	using System;
using System.Collections.Generic;
using System.Text;

namespace Model.DynamicBody.Move
{
	public class CheckPosImpl : ICheckPos
    {
		private readonly IDynamicBody entity;

		/// <summary>
		/// Default constructor
		/// </summary>
		/// <param name="entity"> the dynamic body's of which we have to check the next available position	 </param>

		public CheckPosImpl(IDynamicBody entity)
		{
			this.entity = entity;
		}

		public Boolean PossiblePos(ValueTuple<int, int> pos)
		{
			return !IsOutOfLimits(pos);
		}

		/// <summary>
		/// Method used to check if a dynamic body's is going out of dungeon's bounds
		/// </summary>
		/// <param name="pos">pos, dynamic body's current coordinates </param>
		/// <returns>true if the dynamic body is out of bounds</returns>
		private Boolean IsOutOfLimits(ValueTuple<int, int> pos)
		{
			return ((pos.Item1 + entity.GetDimension().GetLeft() < (int)GameSettings.Value.LimitLeft 
					|| pos.Item1 + entity.GetDimension().GetRight() > (int)GameSettings.Value.LimitRight)
					|| (pos.Item2 + entity.GetDimension().GetUp() < (int)GameSettings.Value.LimitUp 
						|| pos.Item2 + entity.GetDimension().GetDown() > (int)GameSettings.Value.LimitDown));
		}
	}
}
