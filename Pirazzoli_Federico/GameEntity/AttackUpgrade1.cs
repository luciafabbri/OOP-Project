using System;

using design.utilities;
using design.enums;


namespace gameEntities.modifiers
{
    public class AttackUpgrade1 : ModifiersImpl
    {
        public AttackUpgrade1(Pair<int, int> coord) 
            : base(coord, Stats.ATTACK, 500, "Attack Upgrade", Entities.ATTACKUPGRADE)
        {

        }

    }
}
