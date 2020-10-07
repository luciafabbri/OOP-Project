using System;

namespace main.worldModel.utilities
{
    /// <summary>
    /// A class listing game parameters
    /// </summary>
    public class GameSettings
    {
        private static readonly int widht = 1280;
        private static readonly int height = 768;
        private static readonly int tilesize = 64;
        private static readonly int totalTies = (widht - tilesize) * (height - tilesize) / (tilesize * tilesize);

        private static readonly int minDoors = 1;
        private static readonly int maxDoors = 4;

        private static readonly int limitRight = widht - tilesize;
        private static readonly int limitLeft = tilesize - 1;
        private static readonly int limitUp = tilesize - 48 - 1;
        private static readonly int limitDown = height - tilesize;

        private static readonly int obstDown = tilesize - 48;

        private static readonly int totCoins = 4;

        private static readonly int finalLevel = 4;

        public GameSettings()
        {
        }
    }    
}
