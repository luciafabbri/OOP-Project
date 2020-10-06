using System;

using design.utilities;
using design.enums;


namespace gameEntities.modifiers
{
    public class AttackSpeed1 : ModifiersImpl
    {
        public AttackSpeed1(Pair<int, int> coord) 
            : base(coord, Stats.PROJ_SPEED, 500, "ROF Upgrade", Entities.ATTACKSPEED1)
        {

        }

    }
}
