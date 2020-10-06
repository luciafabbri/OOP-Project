using System;

using design.utilities;
using design.enums;

namespace gameEntities
{
    public abstract class GameEntity
    {

        private Pair<int, int> position;
        private Entities typeEnt;

        public GameEntity(Pair<int, int> pos, Entities ent)
        {
            this.position = pos;
            this.typeEnt = ent;
        }

        public Pair<int, int> GetPos()
        {
            return position;
        }

        public void setPosition(Pair<int, int> pos)
        {
            this.position = pos;
        }
        public Entities GetEnt()
        {
            return typeEnt;
        }

        public void setEntities(Entities ent)
        {
            this.typeEnt = ent;
        }
    }
}
