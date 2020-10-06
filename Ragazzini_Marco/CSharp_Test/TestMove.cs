using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Model.DynamicBody;
using Model.DynamicBody.Character.Enemy;
using Model.DynamicBody.Move;


namespace CSharp_Test
{
	///<summary>
	///Class that tests the color of the nutrition filter entities.
	///</summary>

	[TestClass]
	public class TestMove
	{

		///<summary>
		///Method that tests the color of EMPTY SQUARE, STONE ENTITY, CELL DEAD.
		///</summary>
		[TestMethod]
		public void TestStraightMove()
		{
			/*
			 * CONTROLLO CHE PER OGNI DIREZIONE IL NEMICO SI MUOVA DALLA PARTE GIUSTA
			 */

			Direction.GetDirectionList(true).ForEach(d => {

                IEnemy testStraight = new EnemyImpl(new ValueTuple<int, int>(128, 128), 10, 1, 100, d);
				testStraight.UpdatePos();
				Assert.AreEqual(new ValueTuple<int, int>(128 + Direction.GetAbscissa(d), 128 + Direction.GetOrdinate(d)),
						testStraight.GetPosition());
				testStraight.UpdatePos();
				testStraight.UpdatePos();
				testStraight.UpdatePos();
				Assert.AreEqual(new ValueTuple<int, int>(128 + Direction.GetAbscissa(d) * 4, 128 + Direction.GetOrdinate(d) * 4),
						testStraight.GetPosition());
			});

			/*
			 * CONTROLLO CHE IL NEMICO UNA VOLTA SBATTUTO NEL LIMITI CAMBI DIREZIONI
			 */
			IEnemy testStraight = new EnemyImpl(new ValueTuple<int, int>(64, (int)GameSettings.Value.LimitDown - 64), 10, 1, 100,
					Direction.EnumDirection.SOUTH);

			// IL NEMICO SI MUOVE CORRETTAMENTE VERSO IL BASSO ED ORA SI TROVA ATTACCATO AL
			// MURO
			testStraight.UpdatePos();
			Console.WriteLine((int)GameSettings.Value.LimitDown - 63);
			Console.WriteLine("EXP" + new ValueTuple<int, int>(64, (int)GameSettings.Value.LimitDown - 63) + "RETURN" + testStraight.GetPosition());
			Assert.AreEqual(new ValueTuple<int, int>(64, (int)GameSettings.Value.LimitDown - 63), testStraight.GetPosition());
			Assert.AreEqual(Direction.EnumDirection.SOUTH, testStraight.GetDirection());

			// IL NEMICO CERCA DI MUOVERSI VERSO IL BASSO MA ESSENDO ATTACCATO AL MURO
			// SBATTE E CAMBIA DIREZIONE
			testStraight.UpdatePos();
			Console.WriteLine((int)GameSettings.Value.LimitDown - 63);
			Console.WriteLine("EXP" + new ValueTuple<int, int>(64, (int)GameSettings.Value.LimitDown - 63) + "RETURN" + testStraight.GetPosition());
			Assert.AreEqual(new ValueTuple<int, int>(64, (int)GameSettings.Value.LimitDown - 63), testStraight.GetPosition());
			Assert.AreEqual(Direction.EnumDirection.NORTH, testStraight.GetDirection());

			// IL NEMICO HA CAMBIATO DIREZIONE E SI MUOVE DALLA PARTE OPPOSTA
			testStraight.UpdatePos();
			Assert.AreEqual(new ValueTuple<int, int>(64, (int)GameSettings.Value.LimitDown - 64), testStraight.GetPosition());
			Assert.AreEqual(Direction.EnumDirection.NORTH, testStraight.GetDirection());
		}
	}
}

