using System;

using design.utilities;
using design.enums;

namespace gameEntities
{
    public class Pickupable : GameEntity
    {
        public Pickupable(Pair<int, int> position, Entities ent)
            : base(position, ent)
        {

        }
    }
}
