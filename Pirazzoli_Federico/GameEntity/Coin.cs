using System;

using design.utilities;
using design.enums;

namespace gameEntities
{
    public class Coin : ItemImpl
    {
        public Coin(Pair<int, int> coord) 
            : base(coord, Entities.COIN)
        {

        }

    }
}
