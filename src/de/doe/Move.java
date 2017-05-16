package de.doe;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Move {
	
	Player player;
	Coordinate from;
	Coordinate to;
	
	public Move(String move, Player player) {
		
		String lowerCaseMove = move.toLowerCase();
		this.player = player;
		
		String[] parts = lowerCaseMove.split("-");
		
		from = new Coordinate(parts[0].charAt(1) - '1', 5 - (parts[0].charAt(0) - 'a'));
		to = new Coordinate(parts[1].charAt(1) - '1', 5 - (parts[1].charAt(0) - 'a'));
		
	}
	
	public Move(Player player, int fromX, int fromY, int toX, int toY) {
		super();
		this.player = player;
		this.from = new Coordinate(fromX, fromY);
		this.to = new Coordinate(toX, toY);
	}
	
	public String toChessString() {
		StringBuilder resultBuilder = new StringBuilder();
		resultBuilder.append((char) ('a' + (4 - from.x))).append((char) ('1' + from.y)).append("-")
				.append((char) ('a' + (4 - to.x))).append((char) ('1' + to.y));// TODO
																				// something
																				// is
																				// wrong
																				// here,
																				// run
																				// moveTest
																				// to
																				// see
																				// what
																				// is
																				// wrong
		
		return resultBuilder.toString();
	}
	
	@Override
	public String toString() {
		return "From: " + from.toString() + " To: " + to.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == this)
			return true;
		if (!(obj instanceof Move)) {
			return false;
		}
		
		Move other = (Move) obj;
		
		return new EqualsBuilder().append(this.player, other.player).append(this.from, other.from)
				.append(this.to, other.to).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(player).append(from).append(to).toHashCode();
	}
}
