package enemy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utility.Direction;
import utility.Pair;

class TestMove {
	
	private Enemy monN = new monster("MonN", new Pair<Integer,Integer>(100 ,55), "ciao", 1, 1, TypeMove.STRAIGHT, Direction.NORD);
	private Enemy monS = new monster("MonS", new Pair<Integer,Integer>(100, 615), "ciao", 1, 1, TypeMove.STRAIGHT, Direction.SOUTH);
	private Enemy monE = new monster("MonE", new Pair<Integer,Integer>(1190, 100), "ciao", 1, 1, TypeMove.STRAIGHT, Direction.EAST);
	private Enemy monW = new monster("MonW", new Pair<Integer,Integer>(55, 100), "ciao", 1, 1, TypeMove.STRAIGHT, Direction.WEST);
	private Enemy monNE = new monster("MonNE", new Pair<Integer,Integer>(100, 100), "ciao", 1, 1, TypeMove.STRAIGHT, Direction.NORD_EAST);
	private Enemy monNW = new monster("MonNW", new Pair<Integer,Integer>(100, 100), "ciao", 1, 1, TypeMove.STRAIGHT, Direction.NORD_WEST);
	private Enemy monSE = new monster("MonSE", new Pair<Integer,Integer>(100, 100), "ciao", 1, 1, TypeMove.STRAIGHT, Direction.SOUTH_EAST);
	private Enemy monSW = new monster("MonNW", new Pair<Integer,Integer>(100, 100), "ciao", 1, 1, TypeMove.STRAIGHT, Direction.SOUTH_WEST);
	private int x = 0;
	@Test
	void test() {
		
		while(x<20) {
			x++;			
			//TEST NORD
			/*monN.updatePos();
			System.out.println(monN.getName() + " ->" + monN.getPos());
			assertEquals(new Pair<Integer,Integer>(100,100-x), monN.getPos());
			//TEST SOUTH
			monS.updatePos();
			System.out.println(monS.getName() + " ->" + monS.getPos());
			assertEquals(new Pair<Integer,Integer>(100-x,100), monS.getPos());
			//TEST EAST
			monE.updatePos();
			System.out.println(monE.getName() + " ->" + monE.getPos());
			assertEquals(new Pair<Integer,Integer>(100,100+x), monE.getPos());*/	
			//TEST WEST
			monW.updatePos();
			System.out.println(monW.getName() + " ->" + monW.getPos());
			/*assertEquals(new Pair<Integer,Integer>(100,100-x), monW.getPos());	
			//TEST NORD EAST
			monNE.updatePos();
			System.out.println(monNE.getName() + " ->" + monNE.getPos());
			assertEquals(new Pair<Integer,Integer>(100+x,100+x), monNE.getPos());	
			//TEST NORD WEST
			monNW.updatePos();
			System.out.println(monNW.getName() + " ->" + monNW.getPos());
			assertEquals(new Pair<Integer,Integer>(100+x,100-x), monNW.getPos());	
			//TEST SOUTH EAST
			monSE.updatePos();
			System.out.println(monSE.getName() + " ->" + monSE.getPos());
			assertEquals(new Pair<Integer,Integer>(100-x,100+x), monSE.getPos());	*/
			//TEST SOUTH WEST
			monSW.updatePos();
			System.out.println(monSW.getName() + " ->" + monSW.getPos());
			assertEquals(new Pair<Integer,Integer>(100-x,100+x), monSW.getPos());	
		}
				
	}

}
