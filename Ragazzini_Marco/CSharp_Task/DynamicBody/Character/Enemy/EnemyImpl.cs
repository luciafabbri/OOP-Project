using System;
using System.Collections.Generic;
using System.Reflection.PortableExecutable;
using System.Text;
using Model.DynamicBody.Character.Enemy.Move;
using Model.DynamicBody.Move;

namespace Model.DynamicBody.Character.Enemy
{
    public class EnemyImpl : IEnemy
    {
        private ValueTuple<int, int> Position;
        private readonly int Damage;
        private readonly int Speed;
        private int Health;
        private readonly IEnemyMovement Move;
        private Direction.EnumDirection Direction;
       

        public EnemyImpl(ValueTuple<int, int> pos, int damage, int speed, int health, Direction.EnumDirection dir)
        {
            this.Position = pos;
            this.Damage = damage;
            this.Speed = speed;
            this.Health = health;
            this.Direction = dir;
            Move = new StraightMove(this);
        }

        public int GetDamage()
        {
            return Damage;
        }

        public UpDownLeftRight<int> GetDimension()
        {
            return EnemyDimension.GetDimension(EnemyDimension.EnumDimension.DEFAULT);
        }

        public Direction.EnumDirection GetDirection()
        {
            return Direction;
        }

        public (int, int) GetPosition()
        {
            return Position;
        }

        public bool IsAlive()
        {
            return Health > 0;
        }

        public void TakeDamage(int damage)
        {
            Health -= damage;
        }

        public void UpdatePos()
        {
            Position = Move.NextPos(Position, Speed, Direction);
            Direction = Move.GetDirection();
        }
    }
}
