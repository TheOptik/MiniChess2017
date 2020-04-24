package de.theoptik.doe;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == this)
			return true;
		if (!(obj instanceof Coordinate)) {
			return false;
		}
		
		Coordinate other = (Coordinate) obj;
		
		return new EqualsBuilder().append(this.x, other.x).append(this.y, other.y).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.x).append(this.y).toHashCode();
	}
	
}
