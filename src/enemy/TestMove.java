package enemy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utility.Direction;

class TestMove {
	
	Enemy mon1 = new monster("mon1", new Pair<Integer,Integer>(2,2), "Palude", 1, 200, TypeMove.SQUARE, Direction.NORD);
	
	@Test
	void test() {
		
		mon1.updatePos();
		assertEquals(new Pair<Integer,Integer>(3,2), mon1.getPos());
		mon1.updatePos();
		assertEquals(new Pair<Integer,Integer>(4,2), mon1.getPos());
		mon1.updatePos();
		assertEquals(new Pair<Integer,Integer>(5,2), mon1.getPos());
		mon1.updatePos();
		assertEquals(new Pair<Integer,Integer>(5,3), mon1.getPos());
				
	}

}
