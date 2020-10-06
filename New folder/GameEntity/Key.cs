using System;

using design.utilities;
using design.enums;

namespace gameEntities
{
    public class Key : ItemImpl
    {
        public Key(Pair<int, int> coord) 
            : base(coord, Entities.KEY)
        {

        }

    }
}
