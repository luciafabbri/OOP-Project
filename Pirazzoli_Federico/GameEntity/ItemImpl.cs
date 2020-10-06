using System;

using design.enums;
using design.utilities;


namespace gameEntities
{
    public class ItemImpl : Pickupable 
    {
        public ItemImpl(Pair<int, int> position, Entities typeEnt) : base(position, typeEnt)
        {
        
        }

    }
}
