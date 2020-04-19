package design.utilities.enums;

import java.util.*;

public enum Pickupables {

	COIN(0), 
	KEY(1), 
	ATTACKUPGRADE1(2), 
	HEALTHUPGRADE1(3);

	private Integer pickupableCode;
	private static Map<Integer, Pickupables> map = new HashMap<>();

	private Pickupables(Integer entityCode) {
		this.pickupableCode = entityCode;
	}

	static {
		for (Pickupables entity : Pickupables.values()) {
			map.put(entity.pickupableCode, entity);
		}
	}

	public static Pickupables valueOf(int entity) {
		return map.get(entity);
	}

	public int getpickupableCode() {
		return pickupableCode;
	}

}
