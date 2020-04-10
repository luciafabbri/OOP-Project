package enemy;

import org.junit.jupiter.api.Test;

class TestMove {
	
	
	@Test
	void testStraight() {
		
		/*Enemy monN = new monster("MonN", new Pair<Integer,Integer>(100, 100), "ciao", 1, 1, TypeMove.STRAIGHT, Direction.NORD);
		Enemy monS = new monster("MonS", new Pair<Integer,Integer>(100, 615), "ciao", 1, 1, TypeMove.STRAIGHT, Direction.SOUTH);
		Enemy monE = new monster("MonE", new Pair<Integer,Integer>(1190, 100), "ciao", 1, 1, TypeMove.STRAIGHT, Direction.EAST);
		Enemy monW = new monster("MonW", new Pair<Integer,Integer>(55, 100), "ciao", 1, 1, TypeMove.STRAIGHT, Direction.WEST);
		Enemy monNE = new monster("MonNE", new Pair<Integer,Integer>(1190, 57), "ciao", 1, 1, TypeMove.STRAIGHT, Direction.NORD_EAST);
		Enemy monNW = new monster("MonNW", new Pair<Integer,Integer>(55, 55), "ciao", 1, 1, TypeMove.STRAIGHT, Direction.NORD_WEST);
		Enemy monSE = new monster("MonSE", new Pair<Integer,Integer>(1190, 614), "ciao", 1, 1, TypeMove.STRAIGHT, Direction.SOUTH_EAST);
		Enemy monSW = new monster("MonNW", new Pair<Integer,Integer>(55, 616), "ciao", 1, 1, TypeMove.STRAIGHT, Direction.SOUTH_WEST);
		int x = 0;
		
		while(x<20) {
			x++;			
			//TEST NORD
			monN.updatePos();
			System.out.println(monN.getName() + " -> " + monN.getPos());
			assertEquals(new Pair<Integer,Integer>(100,100-x), monN.getPos());
			//TEST SOUTH
			monS.updatePos();
			System.out.println(monS.getName() + " -> " + monS.getPos());
			assertEquals(new Pair<Integer,Integer>(100-x,100), monS.getPos());
			//TEST EAST
			monE.updatePos();
			System.out.println(monE.getName() + " -> " + monE.getPos());
			assertEquals(new Pair<Integer,Integer>(100,100+x), monE.getPos());
			//TEST WEST
			monW.updatePos();
			System.out.println(monW.getName() + " -> " + monW.getPos());
			assertEquals(new Pair<Integer,Integer>(100,100-x), monW.getPos());	
			//TEST NORD EAST
			monNE.updatePos();
			System.out.println(monNE.getName() + " -> " + monNE.getPos());
			assertEquals(new Pair<Integer,Integer>(100+x,100+x), monNE.getPos());
			//TEST NORD WEST
			monNW.updatePos();
			System.out.println(monNW.getName() + " -> " + monNW.getPos());
			assertEquals(new Pair<Integer,Integer>(100+x,100-x), monNW.getPos());	
			//TEST SOUTH EAST
			monSE.updatePos();
			System.out.println(monSE.getName() + " -> " + monSE.getPos());
			assertEquals(new Pair<Integer,Integer>(100-x,100+x), monSE.getPos());
			//TEST SOUTH WEST
			monSW.updatePos();
			System.out.println(monSW.getName() + " -> " + monSW.getPos());
			assertEquals(new Pair<Integer,Integer>(100-x,100+x), monSW.getPos());	
		}*/
				
	}
	
	@Test
	void testTeleport() {
		
		/*Enemy mon = new monster("Mon", new Pair<Integer,Integer>(100, 100), "ciao", 1, 1, TypeMove.TELEPORT, Direction.getRandomDir());
		int x = 0;
		
		while(x<25) {
			x++;
			mon.updatePos();
			System.out.println(mon.getName() + " -> " + mon.getPos());
			
		}*/
		
	}
	
	@Test
	void testRandom() {
		/*Enemy mon = new Monster("Mon", new Pair<Integer,Integer>(100, 615), "ciao", 1, 1, TypeMove.RANDOM, Direction.SOUTH);
		int x = 0;
		
		while(x<35) {
			x++;
			mon.updatePos();
			System.out.println(mon.getName() + " -> " + mon.getPos());
			System.out.println(mon.getDirection());
			
		}*/
	}
	
	@Test
	void testImmobilized() {/*
		Enemy mon = new Monster("Mon", new Pair<Integer,Integer>(100, 100), "ciao", 1, 1, TypeMove.IMMOBILIZED, Direction.SOUTH);
		mon.updatePos();
		System.out.println(mon.getDirection());
			*/
	}

}
