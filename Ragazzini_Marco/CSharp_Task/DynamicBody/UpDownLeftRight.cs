using System;
using System.Collections.Generic;
using System.Text;

/// <summary>
/// Class used to represents all the different dynamic body dimensions based on their images, 
///in order to be as real as possible
/// </summary>
/// <param name="X"> generic param X that will be replace by any type passed as a parameter</param>
namespace Model.DynamicBody
{
	public class UpDownLeftRight <X>
    {
		private readonly X up;
		private readonly X down;
		private readonly X left;
		private readonly X right;

		/// <summary>
		/// Default constructor
		/// </summary>
		/// <param name="up"> up, dynamic body's up dimension</param>
		/// <param name="down"> down, dynamic body's down dimension</param>
		/// <param name="left"> left, dynamic body's left dimension</param>
		/// <param name="right"> right, dynamic body's right dimension</param>
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
