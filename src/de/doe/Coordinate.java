package de.doe;

public class Coordinate {
	
	public int x;
	public int y;
	
	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "x: " + x + " y:" + y;
	}
	
}
