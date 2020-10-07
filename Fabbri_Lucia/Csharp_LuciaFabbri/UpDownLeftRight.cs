using System;

namespace dynamicBody
{
    /// <summary>
    /// Class used to represents all the different dynamic body dimensions based on their images, in order to be as real as possible
    /// </summary>
    /// <typeparam name="X">  generic param X that will be replace by any type passed as a parameter </typeparam>

    public class UpDownLeftRight<X>
    {
        private readonly X up;
	    private readonly X down;
	    private readonly X left;
	    private readonly X right;

	    public UpDownLeftRight(X up, X down, X left, X right)
        {
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
        }

        public X GetUp()
        {
            return up;
        }

        public X GetDown()
        {
            return down;
        }

        public X GetLeft()
        {
            return left;
        }

        public X GetRight()
        {
            return right;
        }
    }
}
