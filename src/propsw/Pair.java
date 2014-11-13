package propsw;

public class Pair<T1, T2> {

	private T1 x;
	private T2 y;
	
	public Pair(T1 xI, T2 yI){
		x = xI;
		y = yI;
	}

	public T1 getX() {
		return x;
	}

	public void setX(T1 x) {
		this.x = x;
	}

	public T2 getY() {
		return y;
	}

	public void setY(T2 y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "{"+x.toString()+","+y.toString()+"}";
	}
	
	
	
	
}
