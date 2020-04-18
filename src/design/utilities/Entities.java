package design.utilities;

import java.util.*;

public enum Entities {

	COIN(0), 
	KEY(1), 
	ATTACKUPGRADE1(2), 
	HEALTHUPGRADE1(3),
	BOULDER(4),
	STAIR(5);

	private Integer entityCode;
	private static Map<Integer, Entities> map = new HashMap<>();

	private Entities(Integer entityCode) {
		this.entityCode = entityCode;
	}

	static {
		for (Entities entity : Entities.values()) {
			map.put(entity.entityCode, entity);
		}
	}

	public static Entities valueOf(int entity) {
		return map.get(entity);
	}

	public int getEntityCode() {
		return entityCode;
	}

}
