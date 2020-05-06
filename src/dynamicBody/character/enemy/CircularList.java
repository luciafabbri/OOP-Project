package dynamicBody.character.enemy;

import java.util.ArrayList;

public class CircularList<E> extends ArrayList<E> {

	private static final long serialVersionUID = 1L;	
		
	public CircularList() {
		super();
	}
	
	public E get(int index)  {
		int value = index;
		
		if(value < 0) {
			value = size() + value;
		}
		
		return super.get(value % size());
	}

}
