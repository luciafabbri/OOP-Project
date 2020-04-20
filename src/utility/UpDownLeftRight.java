package utility;

public class UpDownLeftRight <X> {
	
	private final X up;
	private final X down;
	private final X left;
	private final X right;
	
	public UpDownLeftRight(X up, X down, X left, X right) {
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}

	public X getUp() {
		return up;
	}

	public X getDown() {
		return down;
	}

	public X getLeft() {
		return left;
	}

	public X getRight() {
		return right;
	}
	
	

}
