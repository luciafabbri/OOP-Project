using System;
using System.Collections.Generic;
using System.Text;

namespace Model.DynamicBody
{
	public static class GameSettings
	{
		public enum Value
        {
			Width = 1280,
			Height = 768,
			Tilesize = 64,

			LimitRight = Width - Tilesize,
			LimitLeft = Tilesize - 1,
			LimitUp = Tilesize - 48 - 1,
			LimitDown = Height - Tilesize
		}
    }
}
