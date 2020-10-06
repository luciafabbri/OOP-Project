using System;
using System.Collections.Generic;
using System.Text;
using Model.DynamicBody.Character.Enemy.Move.Check;
using Model.DynamicBody.Move;

namespace Model.DynamicBody.Character.Enemy.Move
{
	public class StraightMove : IEnemyMovement
    {
		private ICheckEnemy Check;
		private Direction.EnumDirection nextDir;

		/// <summary>
		/// Default constructor
		/// </summary>
		/// <param name="character">the character who need to move</param>
		public StraightMove(ICharacter character)
		{
			Check = new CheckEnemyImpl(character);
		}

		public ValueTuple<int, int> NextPos(ValueTuple<int, int> pos, int speed, Direction.EnumDirection dir)
		{

			ValueTuple<int, int> nextPos = new ValueTuple<int, int>(pos.Item1 + (Direction.GetAbscissa(dir) * speed),
					pos.Item2 + (Direction.GetOrdinate(dir) * speed));
			nextDir = dir;

			if (Check.PossiblePos(nextPos))
			{
				return nextPos;
			}
			else
			{ 
				this.nextDir = Check.ChangeDir(nextPos, dir);
				return pos;

			}

		}

		public Direction.EnumDirection GetDirection()
		{
			return nextDir;
		}

    }
}
