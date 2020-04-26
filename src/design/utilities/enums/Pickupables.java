package design.utilities.enums;

import java.util.*;

/**
 * Enumeration listing the pickupables, the entities that the player can pick up
 * and consume
 *
 */
public enum Pickupables {

	COIN(0), KEY(1), ATTACKUPGRADE1(2), HEALTHUPGRADE1(3);

	private Integer pickupableCode;
	private static Map<Integer, Pickupables> map = new HashMap<>();

	private Pickupables(Integer entityCode) {
		this.pickupableCode = entityCode;
	}

	static {
		for (Pickupables pu : Pickupables.values()) {
			map.put(pu.pickupableCode, pu);
		}
	}

	/** 
	 * Through a statically generated map association, the enumeration elements can be accessed through an integer code
	 * @param pickupable code
	 * @return associated pickupable entity
	 */
	public static Pickupables valueOf(int pickupableCode) {
		return map.get(pickupableCode);
	}

}
