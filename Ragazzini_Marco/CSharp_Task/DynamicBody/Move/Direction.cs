using System;
using System.Collections.Generic;
using System.Data;
using System.Text;

namespace Model.DynamicBody.Move
{
    public static class Direction
	{
		public enum EnumDirection
		{
			NORTH_WEST,
			NORTH,
			NORTH_EAST,
			EAST,
			SOUTH_EAST,
			SOUTH,
			SOUTH_WEST,
			WEST
		}

		static readonly Dictionary<EnumDirection, ValueTuple<int, int>> DirMap = new Dictionary<EnumDirection, ValueTuple<int, int>>
		{
			{ EnumDirection.NORTH_WEST, new ValueTuple<int, int>(-1, -1) },
			{ EnumDirection.NORTH, new ValueTuple<int, int>(0, -1) },
			{ EnumDirection.NORTH_EAST, new ValueTuple<int, int>(1, -1) },
            { EnumDirection.EAST, new ValueTuple<int, int>(1, 0) },
			{ EnumDirection.SOUTH_EAST, new ValueTuple<int, int>(1, 1) },
			{ EnumDirection.SOUTH, new ValueTuple<int, int>(0, 1) },
			{ EnumDirection.SOUTH_WEST, new ValueTuple<int, int>(-1, 1) },
			{ EnumDirection.WEST, new ValueTuple<int, int>(-1, 0) }
		};
		public static int GetAbscissa(EnumDirection Dir)
		{
			return DirMap[Dir].Item1;
		}

		public static int GetOrdinate(EnumDirection Dir)
		{
			return DirMap[Dir].Item2;
		}

        public static List<EnumDirection> GetDirectionList(bool i)
		{
			List<EnumDirection> listEnum = new List<EnumDirection>();

            foreach (EnumDirection Dir in Enum.GetValues(typeof(EnumDirection)))
			{
				if(((DirMap[Dir].Item1 * DirMap[Dir].Item2) == 0) == i)
                {
                    listEnum.Add(Dir);
                }
            }
			return listEnum;
		}
	}
}
