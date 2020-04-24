package de.theoptik.doe;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Move {

	Player player;
	Coordinate from;
	Coordinate to;

	public Move(String move, Player player) {

		if (move.length() == 5) {
			this.player = player;
			String lowerCaseMove = move.toLowerCase();

			String[] parts = lowerCaseMove.split("-");
			if (parts.length == 2 && parts[0].length() == 2 && parts[1].length() == 2) {

				from = new Coordinate(parts[0].charAt(0) - 'a', 5 - (parts[0].charAt(1) - '1'));
				to = new Coordinate(parts[1].charAt(0) - 'a', 5 - (parts[1].charAt(1) - '1'));

				if (from.x > 4 || from.x < 0 || to.x > 4 || to.x < 0 || from.y > 5 || from.y < 0 || to.y > 5
						|| to.y < 0) {
					throwIllegalArgumentException();
				}

			} else {
				throwIllegalArgumentException();
			}
		} else {
			throwIllegalArgumentException();
		}

	}

	private void throwIllegalArgumentException() {
		throw new IllegalArgumentException("Wrong move Format. Moves should look like this: a1-a2");
	}

	public Move(Player player, int fromX, int fromY, int toX, int toY) {
		super();
		this.player = player;
		this.from = new Coordinate(fromX, fromY);
		this.to = new Coordinate(toX, toY);
	}

	public String toChessString() {
		StringBuilder resultBuilder = new StringBuilder();
		// resultBuilder.append((char) ('a' + (4 - from.x))).append((char) ('1'
		// + from.y)).append("-")
		// .append((char) ('a' + (4 - to.x))).append((char) ('1' + to.y));//
		// TODO
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

		resultBuilder.append((char) ('a' + from.x)).append((char) ('6' - from.y)).append("-")
				.append((char) ('a' + to.x)).append((char) ('6' - to.y));

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
