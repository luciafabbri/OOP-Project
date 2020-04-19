package design.utilities.enums;

import java.util.HashMap;
import java.util.Map;

public enum Entities {

	COIN(0), 
	KEY(1), 
	ATTACKUPGRADE1(2), 
	HEALTHUPGRADE1(3),
	BOULDER(4),
	STAIR(5);
	
	private Integer entityCode;
	private static Map<Integer, Pickupables> map = new HashMap<>();

	private Entities(Integer entityCode) {
		this.entityCode = entityCode;
	}
	
}
