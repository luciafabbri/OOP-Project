using System;
using System.Collections.Generic;
using System.Text;
using Model.DynamicBody.Move;

namespace Model.DynamicBody.Character.Enemy.Move.Check
{
	public class CheckEnemyImpl : CheckPosImpl, ICheckEnemy
	{ 
		private int x, y;
		private Direction.EnumDirection NewDir;
		private ICharacter Character;

        public CheckEnemyImpl(ICharacter character) : base(character)
		{
			this.Character = character;
		}

		public Direction.EnumDirection ChangeDir(ValueTuple<int, int> pos, Direction.EnumDirection dir)
		{

			if (pos.Item1 + Character.GetDimension().GetRight() > (int)GameSettings.Value.LimitRight)
			{
				this.x = - Direction.GetAbscissa(dir);
			}
			else if (pos.Item1 + Character.GetDimension().GetLeft() < (int)GameSettings.Value.LimitLeft)
			{
				this.x = - Direction.GetAbscissa(dir);
			}
			else
			{
				this.x = Direction.GetAbscissa(dir);
			}

			if (pos.Item2 + Character.GetDimension().GetDown() > (int)GameSettings.Value.LimitDown)
			{
				this.y = - Direction.GetOrdinate(dir);
			}
			else if (pos.Item2 + Character.GetDimension().GetUp() < (int)GameSettings.Value.LimitUp)
			{
				this.y = - Direction.GetOrdinate(dir);
			}
			else
			{
				this.y = Direction.GetOrdinate(dir);
			}

			foreach (Direction.EnumDirection d in Enum.GetValues(typeof(Direction.EnumDirection)))
			{
				if (Direction.GetAbscissa(d) == x && Direction.GetOrdinate(d) == y)
				{
					NewDir = d;
				}
			}

			return NewDir;
		}
    }
}
