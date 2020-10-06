using System;

using design.utilities;
using design.enums;

namespace gameEntities.modifiers
{
    public class HealthUpgrade1 : ModifiersImpl
    {
        public HealthUpgrade1(Pair<int, int> coord) 
            : base(coord, Stats.HEALTH, 10, "Health Upgrade", Entities.HEALTHUPGRADE1)
        {

        }

    }
}
