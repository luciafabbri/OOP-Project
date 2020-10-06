using System;
using System.Collections.Generic;
using System.Data;
using System.Text;
using Model.DynamicBody;
using Model.DynamicBody.Move;

namespace Model.DynamicBody.Move
{
	public static class EnemyDimension
	{
		public enum EnumDimension
		{
			DEFAULT
		}

		static readonly Dictionary<EnumDimension, UpDownLeftRight<int>> DimMap = new Dictionary<EnumDimension, UpDownLeftRight<int>>
		{
			{ EnumDimension.DEFAULT, new UpDownLeftRight<int>(0, 63, 15, 46) }
		};
		public static UpDownLeftRight<int> GetDimension(EnumDimension dim)
		{
			return DimMap[dim];
		}
	}
}
