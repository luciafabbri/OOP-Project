using System;

using design.enums;
using design.utilities;


namespace gameEntities.modifiers
{
    public class ModifiersImpl : GameEntity 
    {
        private Stats stat;
        private int modQty;
        private String name;

        public ModifiersImpl(Pair<int, int> position, Stats stat, int qty, string name, Entities typeEnt) : base(position, typeEnt)
        {
            this.stat = stat;
            this.modQty = qty;
            this.name = name;
        }

        public Stats GetStat()
        {
            return stat;
        }

        public int GetModQty()
        {
            return modQty;
        }
    }
}
